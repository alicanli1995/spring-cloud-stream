package com.example.xmlbranching.service;

import com.example.xmlbranching.appconst.AppConstants;
import com.example.xmlbranching.appconst.AppSerdes;
import com.example.xmlbranching.bindings.OrderListenerBinding;
import com.example.xmlbranching.model.Order;
import com.example.xmlbranching.model.OrderEnvelop;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
@Log4j2
@EnableBinding(OrderListenerBinding.class)
public class OrderListenerService {

    @Value("${application.configs.error.topic.name}")
    private String ERROR_TOPIC;

    @StreamListener("xml-input-channel")
    @SendTo({"turkey-orders-channel", "abroad-orders-channel"})
    public KStream<String, Order>[] process(KStream<String, String> input) {

        input.foreach((k, v) -> log.info(String.format("Received XML Order Key: %s, Value: %s", k, v)));

        KStream<String, OrderEnvelop> orderEnvelopKStream = input.map((key, value) -> {
            OrderEnvelop orderEnvelop = new OrderEnvelop();
            orderEnvelop.setXmlOrderKey(key);
            orderEnvelop.setXmlOrderValue(value);
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                orderEnvelop.setValidOrder((Order) jaxbUnmarshaller.unmarshal(new StringReader(value)));
                orderEnvelop.setOrderTag(AppConstants.VALID_ORDER);

                if(orderEnvelop.getValidOrder().getShipTo().getCity().isEmpty()){
                    log.error("Missing destination City");
                    orderEnvelop.setOrderTag(AppConstants.ADDRESS_ERROR);
                }

            } catch (JAXBException e) {
                log.error("Failed to Unmarshal the incoming XML");
                orderEnvelop.setOrderTag(AppConstants.PARSE_ERROR);
            }
            return KeyValue.pair(orderEnvelop.getOrderTag(), orderEnvelop);
        });

        orderEnvelopKStream.filter((k, v) -> !k.equalsIgnoreCase(AppConstants.VALID_ORDER))
                .to(ERROR_TOPIC, Produced.with(AppSerdes.String(), AppSerdes.OrderEnvelop()));

        KStream<String, Order> validOrders = orderEnvelopKStream
                .filter((k, v) -> k.equalsIgnoreCase(AppConstants.VALID_ORDER))
                .map((k, v) -> KeyValue.pair(v.getValidOrder().getOrderId(), v.getValidOrder()));

        validOrders.foreach((k, v) -> log.info(String.format("Valid Order with ID: %s", v.getOrderId())));

        Predicate<String, Order> isTurkey = (k, v) -> v.getShipTo().getCountry().equalsIgnoreCase("turkey");
        Predicate<String, Order> isAbroadOrder = (k, v) -> !v.getShipTo().getCountry().equalsIgnoreCase("turkey");

        return validOrders.branch(isTurkey, isAbroadOrder);

    }



}

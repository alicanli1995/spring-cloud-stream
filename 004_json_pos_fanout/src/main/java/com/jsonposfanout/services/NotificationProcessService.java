package com.jsonposfanout.services;


import com.jsonposfanout.bindings.PosListenerBinding;
import com.jsonposfanout.model.NotificationLast;
import com.jsonposfanout.model.PosInvoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@EnableBinding(PosListenerBinding.class)
public class NotificationProcessService {

    private final RecordBuilder recordBuilder;

    @StreamListener("notification-input-channel")
    @SendTo("notification-output-channel")
    public KStream<String , NotificationLast> process(KStream<String , PosInvoice> input) {
        KStream<String , NotificationLast> notificationKStream = input
                .filter((k,v) -> v.getCustomerType().equalsIgnoreCase(BusinessConst.PRIME.toString()))
                .mapValues(recordBuilder::getNotification);
        notificationKStream.foreach((k,v) -> log.info(String.format("NotificationLast : - Key : %s , Value : %s ",k,v)));
        return notificationKStream;
    }


}

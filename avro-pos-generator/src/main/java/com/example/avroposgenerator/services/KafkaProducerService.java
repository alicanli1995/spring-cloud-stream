package com.example.avroposgenerator.services;


import com.example.avroposgenerator.model.PosInvoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${application.configs.topic.name}")
    private  String TOPIC_NAME;
    private final KafkaTemplate<String , PosInvoice> kafkaTemplate;

    public void sendMessage(PosInvoice posInvoice){
        kafkaTemplate.send(TOPIC_NAME,posInvoice.getStoreID(),posInvoice);
        log.warn(String.format("Producing Invoice No %s ", posInvoice.getInvoiceNumber()));
    }

}



package com.example.kafkaproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String ,String > kafkaTemplate;

    public void sendMessage(String topic, String key, String value){
        log.info(String.format("Producing message - Key : %s and Value : %s" ,key , value));
        kafkaTemplate.send(topic,key,value);
    }

}

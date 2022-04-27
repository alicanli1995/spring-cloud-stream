package com.example.kafkaproducer.controller;


import com.example.kafkaproducer.model.IncomingMessage;
import com.example.kafkaproducer.services.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@CrossOrigin
@RequiredArgsConstructor
public class KafkaMessageController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/post")
    public String sendMessageToKafka(@RequestBody IncomingMessage incomingMessage){
        kafkaProducerService.sendMessage(incomingMessage.getTopic(),incomingMessage.getKey(),incomingMessage.getValue());
        return String.format("Success sending message for key : %s , value : %s" ,
                incomingMessage.getKey(),incomingMessage.getValue());

    }

}

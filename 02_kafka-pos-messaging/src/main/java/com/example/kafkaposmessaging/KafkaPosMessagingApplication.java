package com.example.kafkaposmessaging;

import com.example.kafkaposmessaging.services.InvoiceGeneratorService;
import com.example.kafkaposmessaging.services.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class KafkaPosMessagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPosMessagingApplication.class, args);
    }

    private final KafkaProducerService kafkaProducerService;
    private final InvoiceGeneratorService invoiceGeneratorService;

    @Scheduled(fixedRate = 2_000)
    public void sendMessage(){
        var invoicePos = invoiceGeneratorService.getNextInvoice();
        kafkaProducerService.sendMessage(invoicePos);
    }
}

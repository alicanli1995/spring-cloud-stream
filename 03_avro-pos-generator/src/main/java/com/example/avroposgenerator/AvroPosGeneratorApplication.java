package com.example.avroposgenerator;

import com.example.avroposgenerator.services.InvoiceGeneratorService;
import com.example.avroposgenerator.services.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class AvroPosGeneratorApplication {
    private final KafkaProducerService kafkaProducerService;
    private final InvoiceGeneratorService invoiceGeneratorService;

    public static void main(String[] args) {
        SpringApplication.run(AvroPosGeneratorApplication.class, args);
    }
    @Scheduled(fixedRate = 4_000)
    public void sendMessage(){
        var invoicePos = invoiceGeneratorService.getNextInvoice();
        kafkaProducerService.sendMessage(invoicePos);
    }


}

package com.example.window_count.configs;

import com.example.window_count.model.SimpleInvoice;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvoiceTimeExtractor implements TimestampExtractor {

    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long prevTime) {
        SimpleInvoice simpleInvoice = (SimpleInvoice) consumerRecord.value();
        return ((simpleInvoice.getCreatedTime()> 0 ) ? simpleInvoice.getCreatedTime() : prevTime);
    }

    @Bean
    public TimestampExtractor invoiceTimesExtractor(){
        return new InvoiceTimeExtractor();
    }
}

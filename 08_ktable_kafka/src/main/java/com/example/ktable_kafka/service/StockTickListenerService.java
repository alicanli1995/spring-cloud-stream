package com.example.ktable_kafka.service;

import com.example.ktable_kafka.bindings.StockListenerBinding;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(StockListenerBinding.class)
public class StockTickListenerService {

    @StreamListener("stock-input-channel")
    public void process(KTable<String , String> input){
        input.filter((k,v) -> k.contains("ZIRAATBANK"))
                .toStream()
                .foreach((k,v) -> log.warn(String.format("Key : %s , Value : %s ", k , v)));
    }

}

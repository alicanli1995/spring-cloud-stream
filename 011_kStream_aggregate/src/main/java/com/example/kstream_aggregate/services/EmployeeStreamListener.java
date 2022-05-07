package com.example.kstream_aggregate.services;

import com.example.kstream_aggregate.Employee;
import com.example.kstream_aggregate.binding.KafkaListenerBinding;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@EnableBinding(KafkaListenerBinding.class)
public class EmployeeStreamListener {

    private final RecordBuilder recordBuilder;

    @StreamListener("employee-input-channel")
    public void process(KStream<String , Employee> input){
        input.peek((k,v) -> log.info("Key : {} , Value : {} " ,k ,v ))
                .groupBy((k,v) -> v.getDepartment())
                .aggregate(
                        recordBuilder::init,
                        (k ,v , aggV) -> recordBuilder.aggregate(v,aggV)
                ).toStream()
                .foreach((k,v) -> log.warn("Key : {} , Value :  {}" , k ,v ));
    }

}

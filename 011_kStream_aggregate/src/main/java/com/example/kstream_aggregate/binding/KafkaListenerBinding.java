package com.example.kstream_aggregate.binding;

import com.example.kstream_aggregate.Employee;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface KafkaListenerBinding {

    @Input("employee-input-channel")
    KStream<String , Employee> process();
}

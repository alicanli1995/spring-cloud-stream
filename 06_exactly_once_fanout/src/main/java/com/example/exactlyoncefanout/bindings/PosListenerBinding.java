package com.example.exactlyoncefanout.bindings;



import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface PosListenerBinding {

    @Input("pos-input-channel")
    KStream<String, com.example.exact.model.PosInvoice> notificationInputStream();

}

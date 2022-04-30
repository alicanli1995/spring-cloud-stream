package com.example.bindings;


import com.example.model.HadoopRecord;
import com.example.model.Notification;
import com.example.model.PosInvoice;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface PosListenerBinding {

    @Input("notification-input-channel")
    KStream<String, PosInvoice> notificationInputStream();

    @Input("notification-output-channel")
    KStream<String, Notification> notificationOutputStream();

    @Input("hadoop-input-channel")
    KStream<String, PosInvoice> hadoopInputStream();

    @Input("hadoop-output-channel")
    KStream<String, HadoopRecord> hadoopOutputStream();


}

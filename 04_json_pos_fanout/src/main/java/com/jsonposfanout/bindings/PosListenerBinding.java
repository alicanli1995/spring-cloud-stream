package com.jsonposfanout.bindings;


import com.jsonposfanout.model.HadoopRecordLast;
import com.jsonposfanout.model.NotificationLast;
import com.jsonposfanout.model.PosInvoice;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface PosListenerBinding {

    @Input("notification-input-channel")
    KStream<String, PosInvoice> notificationInputStream();

    @Input("notification-output-channel")
    KStream<String, NotificationLast> notificationOutputStream();

    @Input("hadoop-input-channel")
    KStream<String, PosInvoice> hadoopInputStream();

    @Input("hadoop-output-channel")
    KStream<String, HadoopRecordLast> hadoopOutputStream();


}

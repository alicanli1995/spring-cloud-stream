package com.example.rewards_reduce_aggregate.bindings;

import com.example.exact.model.Notification;
import com.example.exact.model.PosInvoice;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface PosListenerBinding {

    @Input("invoice-input-channel")
    KStream<String, PosInvoice> invoiceInputStream();

    @Output("notification-output-channel")
    KStream<String, Notification> notificationOutputStream();

}
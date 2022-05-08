package com.example.window_count.binding;

import com.example.window_count.model.SimpleInvoice;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface InvoiceListenerBinding {

    @Input("invoice-input-channel")
    KStream<String , SimpleInvoice> invoiceInputStream();
}

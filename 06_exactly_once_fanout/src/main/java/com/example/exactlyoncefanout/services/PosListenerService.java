package com.example.exactlyoncefanout.services;

import com.example.exactlyoncefanout.bindings.PosListenerBinding;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(PosListenerBinding.class)
@RequiredArgsConstructor
public class PosListenerService {

    private final RecordBuilder recordBuilder;

    @StreamListener("pos-input-channel")
    public void process(KStream<String, com.example.exact.model.PosInvoice> invoiceKStream){
        KStream<String , com.example.exact.model.HadoopRecord > hadoopRecordKStream = invoiceKStream
                .mapValues(recordBuilder::getMaskedInvoice)
                .flatMapValues(recordBuilder::getHadoopRecords);

        KStream<String  , com.example.exact.model.Notification > notificationKStream = invoiceKStream
                .filter( (k,v) -> v.getCustomerType().equalsIgnoreCase("PRIME"))
                .mapValues(recordBuilder::getNotification);

        hadoopRecordKStream.foreach((k,v) -> log.warn(String.format("Hadoop : -> Key : %s , Value : %s") , k , v));
        notificationKStream.foreach((k,v) -> log.warn(String.format("Notification : -> Key : %s , Value : %s") , k , v));

        hadoopRecordKStream.to("hadoop-sink-topic");
        notificationKStream.to("loyalty-topic");


    }

}

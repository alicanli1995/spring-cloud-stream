package com.jsonposfanout.services;

import com.jsonposfanout.model.HadoopRecordLast;
import com.jsonposfanout.model.LineItem;
import com.jsonposfanout.model.NotificationLast;
import com.jsonposfanout.model.PosInvoice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordBuilder {


    public NotificationLast getNotification(PosInvoice invoice){
        NotificationLast notificationLast = new NotificationLast();
        notificationLast.setInvoiceNumber(invoice.getInvoiceNumber());
        notificationLast.setCustomerCardNo(invoice.getCustomerCardNo());
        notificationLast.setTotalAmount(invoice.getTotalAmount());
        notificationLast.setEarnedLoyaltyPoints(invoice.getTotalAmount() * 0.02);
        return notificationLast;
    }

    public PosInvoice getMaskedInvoice(PosInvoice invoice){
        invoice.setCustomerCardNo(null);
        if (invoice.getDeliveryType().equalsIgnoreCase("HOME-DELIVERY")) {
            invoice.getDeliveryAddress().setAddressLine(null);
            invoice.getDeliveryAddress().setContactNumber(null);
        }
        return invoice;
    }

    public List<HadoopRecordLast> getHadoopRecords(PosInvoice invoice){
        List<HadoopRecordLast> records = new ArrayList<>();

        for (LineItem i : invoice.getInvoiceLineItems()) {
            HadoopRecordLast record = new HadoopRecordLast();
            record.setInvoiceNumber(invoice.getInvoiceNumber());
            record.setCreatedTime(invoice.getCreatedTime());
            record.setStoreID(invoice.getStoreID());
            record.setPosID(invoice.getPosID());
            record.setCustomerType(invoice.getCustomerType());
            record.setPaymentMethod(invoice.getPaymentMethod());
            record.setDeliveryType(invoice.getDeliveryType());
            record.setItemCode(i.getItemCode());
            record.setItemDescription(i.getItemDescription());
            record.setItemPrice(i.getItemPrice());
            record.setItemQty(i.getItemQty());
            record.setTotalValue(i.getTotalValue());
            if (invoice.getDeliveryType().equalsIgnoreCase("HOME-DELIVERY")) {
                record.setCity(invoice.getDeliveryAddress().getCity());
                record.setState(invoice.getDeliveryAddress().getState());
                record.setPinCode(invoice.getDeliveryAddress().getPinCode());
            }
            records.add(record);
        }
        return records;
    }

}

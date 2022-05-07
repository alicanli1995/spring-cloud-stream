package com.example.rewards_reduce_aggregate.services;

import com.example.exact.model.Notification;
import com.example.exact.model.PosInvoice;
import org.springframework.stereotype.Service;

@Service
public class RecordBuilder {

    public Notification getNotification(PosInvoice invoice){
        Notification notification = new Notification();
        notification.setInvoiceNumber(invoice.getInvoiceNumber());
        notification.setCustomerCardNo(invoice.getCustomerCardNo());
        notification.setTotalAmount(invoice.getTotalAmount());
        notification.setEarnedLoyaltyPoints(invoice.getTotalAmount() * 0.02);
        notification.setTotalLoyaltyPoints(notification.getEarnedLoyaltyPoints());
        return notification;
    }
}
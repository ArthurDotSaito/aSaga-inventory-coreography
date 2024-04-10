package com.saito.inventory.adapters.in.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class ReceiveSaleToDebitInventoryConsumer {

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debt")
    public void receive(){

    }
}

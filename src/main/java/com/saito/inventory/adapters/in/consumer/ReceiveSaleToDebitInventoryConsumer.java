package com.saito.inventory.adapters.in.consumer;

import com.saito.inventory.adapters.out.message.SaleMessage;
import com.saito.inventory.application.core.domain.enums.SaleEvent;
import com.saito.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debt")
    public void receive(SaleMessage aSaleMessage){
        if(SaleEvent.CREATED_SALE.equals(aSaleMessage.getEvent())){
            log.info("Starting merchandise separation...");

            debitInventoryInputPort.debit(aSaleMessage.getSale());

            log.info("End merchandise separation.");

        }
    }
}

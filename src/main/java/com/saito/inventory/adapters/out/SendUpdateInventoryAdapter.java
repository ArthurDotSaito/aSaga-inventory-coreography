package com.saito.inventory.adapters.out;

import com.saito.inventory.adapters.out.message.SaleMessage;
import com.saito.inventory.application.core.domain.Sale;
import com.saito.inventory.application.core.domain.enums.SaleEvent;
import com.saito.inventory.application.ports.out.SendUpdatedInventoryOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendUpdateInventoryAdapter implements SendUpdatedInventoryOutPutPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale aSale, SaleEvent aSaleEvent) {
        var saleMessage = new SaleMessage(aSale, aSaleEvent);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}

package com.saito.inventory.adapters.out;

import com.saito.inventory.application.core.domain.Sale;
import com.saito.inventory.application.core.domain.enums.SaleEvent;
import com.saito.inventory.application.ports.out.SendUpdatedInventoryOutPutPort;
import org.springframework.stereotype.Component;

@Component
public class SendUpdateInventoryAdapter implements SendUpdatedInventoryOutPutPort {
    @Override
    public void send(Sale aSale, SaleEvent aSaleEvent) {

    }
}

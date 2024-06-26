package com.saito.inventory.application.ports.out;

import com.saito.inventory.application.core.domain.Sale;
import com.saito.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutPutPort {

    void send(Sale aSale, SaleEvent aSaleEvent);
}

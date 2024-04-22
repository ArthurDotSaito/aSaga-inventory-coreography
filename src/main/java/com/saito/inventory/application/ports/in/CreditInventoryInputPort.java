package com.saito.inventory.application.ports.in;

import com.saito.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale aSale);
}

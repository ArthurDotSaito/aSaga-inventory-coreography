package com.saito.inventory.application.ports.in;

import com.saito.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {
    public void debit(Sale aSale);
}

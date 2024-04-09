package com.saito.inventory.application.ports.in;

import com.saito.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer aProductId);
}

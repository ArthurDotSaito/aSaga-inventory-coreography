package com.saito.inventory.application.ports.out;

import com.saito.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory aInventory);
}

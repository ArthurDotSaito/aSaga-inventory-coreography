package com.saito.inventory.application.ports.out;

import com.saito.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer aProductId);
}

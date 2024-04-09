package com.saito.inventory.application.core.usecase;

import com.saito.inventory.application.core.domain.Inventory;
import com.saito.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.saito.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase  implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(Integer aProductId){
        return findInventoryByProductIdOutputPort.find(aProductId)
                .orElseThrow(() -> new RuntimeException("No product found at inventory"));
    }

}

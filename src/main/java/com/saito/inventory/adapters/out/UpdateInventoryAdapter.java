package com.saito.inventory.adapters.out;

import com.saito.inventory.adapters.out.repository.InventoryRepository;
import com.saito.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.saito.inventory.application.core.domain.Inventory;
import com.saito.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory aInventory) {
        var inventoryEntity = inventoryEntityMapper.toInvetoryEntity(aInventory);
        inventoryRepository.save(inventoryEntity);
    }
}

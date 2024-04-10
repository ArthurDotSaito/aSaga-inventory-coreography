package com.saito.inventory.adapters.out;

import com.saito.inventory.adapters.out.repository.InventoryRepository;
import com.saito.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.saito.inventory.application.core.domain.Inventory;
import com.saito.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> find(Integer aProductId) {
        var inventoryEntity = inventoryRepository.findByProductId(aProductId);
        return inventoryEntity.map(entity -> inventoryEntityMapper.toInvetory(entity));
    }
}

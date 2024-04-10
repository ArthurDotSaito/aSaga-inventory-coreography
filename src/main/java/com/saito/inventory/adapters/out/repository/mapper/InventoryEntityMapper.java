package com.saito.inventory.adapters.out.repository.mapper;

import com.saito.inventory.adapters.out.repository.entity.InventoryEntity;
import com.saito.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInvetory(InventoryEntity aInventory);
}

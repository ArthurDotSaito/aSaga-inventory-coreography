package com.saito.inventory.adapters.out.repository;

import com.saito.inventory.adapters.out.repository.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {

}

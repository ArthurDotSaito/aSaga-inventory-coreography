package com.saito.inventory.config.usecase;

import com.saito.inventory.adapters.out.SendToKafkaAdapter;
import com.saito.inventory.adapters.out.UpdateInventoryAdapter;
import com.saito.inventory.application.core.usecase.CreditInventoryUseCase;
import com.saito.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ){
        return new CreditInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, sendToKafkaAdapter);
    }

}

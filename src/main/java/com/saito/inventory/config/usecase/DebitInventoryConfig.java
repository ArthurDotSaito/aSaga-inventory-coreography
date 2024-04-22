package com.saito.inventory.config.usecase;

import com.saito.inventory.adapters.out.SendToKafkaAdapter;
import com.saito.inventory.adapters.out.UpdateInventoryAdapter;
import com.saito.inventory.application.core.usecase.DebitInventoryUseCase;
import com.saito.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import com.saito.inventory.application.ports.out.SendToKafkaOutPutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ){
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, sendToKafkaAdapter);
    }
}

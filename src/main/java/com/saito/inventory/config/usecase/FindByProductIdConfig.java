package com.saito.inventory.config.usecase;

import com.saito.inventory.adapters.out.FindInventoryByProductIdAdapter;
import com.saito.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter
    ){
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }
}

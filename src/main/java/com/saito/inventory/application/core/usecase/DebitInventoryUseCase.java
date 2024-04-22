package com.saito.inventory.application.core.usecase;

import com.saito.inventory.application.core.domain.Sale;
import com.saito.inventory.application.core.domain.enums.SaleEvent;
import com.saito.inventory.application.ports.in.DebitInventoryInputPort;
import com.saito.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.saito.inventory.application.ports.out.SendToKafkaOutPutPort;
import com.saito.inventory.application.ports.out.UpdateInventoryOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutPutPort sendToKafkaOutPutPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutPutPort sendToKafkaOutPutPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutPutPort = sendToKafkaOutPutPort;
    }

    @Override
    public void debit(Sale aSale){
        try {
            var inventory = findInventoryByProductIdInputPort.find(aSale.getProductId());
            if(inventory.getQuantity() < aSale.getQuantity()){
                throw new RuntimeException("Insuficient Invetory to this sale.");
            }
            inventory.debitQuantity(aSale.getQuantity());
            updateInventoryOutputPort.update(inventory);
            sendToKafkaOutPutPort.send(aSale, SaleEvent.UPDATED_INVENTORY);
        }catch (Exception e){
            log.error("Error = {}", e.getMessage());
            sendToKafkaOutPutPort.send(aSale, SaleEvent.ROLLBACK_INVENTORY);
        }
    }

}

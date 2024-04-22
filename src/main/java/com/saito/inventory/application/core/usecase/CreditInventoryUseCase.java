package com.saito.inventory.application.core.usecase;

import com.saito.inventory.application.core.domain.Sale;
import com.saito.inventory.application.core.domain.enums.SaleEvent;
import com.saito.inventory.application.ports.in.CreditInventoryInputPort;
import com.saito.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.saito.inventory.application.ports.out.SendToKafkaOutPutPort;
import com.saito.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendToKafkaOutPutPort sendToKafkaOutPutPort;

    public CreditInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutPutPort sendToKafkaOutPutPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutPutPort = sendToKafkaOutPutPort;
    }

    @Override
    public void credit(Sale aSale){
        var inventory = findInventoryByProductIdInputPort.find(aSale.getProductId());
        inventory.creditQuantity(aSale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendToKafkaOutPutPort.send(aSale, SaleEvent.ROLLBACK_INVENTORY);
    }
}

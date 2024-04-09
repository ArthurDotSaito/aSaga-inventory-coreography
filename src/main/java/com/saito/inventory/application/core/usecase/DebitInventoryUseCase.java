package com.saito.inventory.application.core.usecase;

import com.saito.inventory.application.core.domain.Sale;
import com.saito.inventory.application.core.domain.enums.SaleEvent;
import com.saito.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.saito.inventory.application.ports.out.SendUpdatedInventoryOutPutPort;
import com.saito.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendUpdatedInventoryOutPutPort sendUpdatedInventoryOutPutPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendUpdatedInventoryOutPutPort sendUpdatedInventoryOutPutPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutPutPort = sendUpdatedInventoryOutPutPort;
    }

    public void debt(Sale aSale){
        var inventory = findInventoryByProductIdInputPort.find(aSale.getProductId());
        if(inventory.getQuantity() < aSale.getQuantity()){
            throw new RuntimeException("Insuficient Invetory to this sale.");
        }
        inventory.debitQuantity(aSale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendUpdatedInventoryOutPutPort.send(aSale, SaleEvent.UPDATED_INVENTORY);
    }

}

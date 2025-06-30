package com.ecom.cartify.service.impl;

import com.ecom.cartify.mapper.GlobalMapper;
import com.ecom.cartify.repositry.InventoryRepositry;
import com.ecom.cartify.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.openapitools.model.InventoryDataDTO;
import org.openapitools.model.InventoryUpdateDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepositry inventoryRepositry;
    private final GlobalMapper mapper;

//    @Override
//    public InventoryDataDTO createInventory(InventoryRegisterDTO inventoryRegisterDTO) {
//        var inventoryEntity = mapper.toInventory(inventoryRegisterDTO);
//        return null;
//    }

    @Override
    public InventoryDataDTO updateInventory(Long productId, InventoryUpdateDTO inventoryUpdateDTO) {
        var existingInventory = inventoryRepositry.findByProduct_ProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for productId: " + productId));
        mapper.toInventoryUpdate(inventoryUpdateDTO, existingInventory);
        var updatedInventory = inventoryRepositry.save(existingInventory);
        return mapper.toInventoryUpdateDto(updatedInventory);
    }

    @Override
    public InventoryDataDTO getInventoryById(Long productId) {
        var inventory = inventoryRepositry.findByProduct_ProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for productId: " + productId));
        return mapper.toInventoryUpdateDto(inventory);
    }

}

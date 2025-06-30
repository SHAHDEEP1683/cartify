package com.ecom.cartify.service;


import org.openapitools.model.InventoryDataDTO;
import org.openapitools.model.InventoryRegisterDTO;
import org.openapitools.model.InventoryUpdateDTO;

public interface InventoryService {

//    InventoryDataDTO createInventory(InventoryRegisterDTO inventoryRegisterDTO);
    InventoryDataDTO updateInventory(Long productId, InventoryUpdateDTO inventoryUpdateDTO);
    InventoryDataDTO getInventoryById(Long productId);
//    InventoryDataDTO deleteInventoryById(Long productId);
}

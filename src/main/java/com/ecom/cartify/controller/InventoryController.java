package com.ecom.cartify.controller;

import com.ecom.cartify.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.InventoryApi;
import org.openapitools.model.InventoryDTO;
import org.openapitools.model.InventoryRegisterDTO;
import org.openapitools.model.InventoryUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InventoryController implements InventoryApi {

    private final InventoryService inventoryService;

//    Create Api Not Required, Create While Adding Product
//    @Override
//    public ResponseEntity<InventoryDTO> registerInventory(@RequestBody InventoryRegisterDTO inventoryRegisterDTO) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(new InventoryDTO(
//                "Inventory Created Successfully",
//                inventoryService.createInventory(inventoryRegisterDTO)
//        ));
//    }

    //Update Stocks
    @Override
    public ResponseEntity<InventoryDTO> updateInventory(Long productId, @RequestBody InventoryUpdateDTO inventoryUpdateDTO) {
        return ResponseEntity.ok(new InventoryDTO(
                "Inventory Updated Successfully",
                inventoryService.updateInventory(productId, inventoryUpdateDTO)
        ));
    }

    //Get Stocks by Product Id
    @Override
    public ResponseEntity<InventoryDTO> getInventoryById(Long productId) {
        return ResponseEntity.ok(new InventoryDTO(
                "Inventory Found Successfully",
                inventoryService.getInventoryById(productId)
        ));
    }

    // Deleting Inventory Is Also Not requ
//    @Override
//    public ResponseEntity<InventoryDTO> deleteInventoryById(Long inventoryId) {
//        return ResponseEntity.ok(new InventoryDTO(
//                "Inventory Deleted Successfully",
//                inventoryService.deleteInventoryById(inventoryId)
//        ));
//    }
}

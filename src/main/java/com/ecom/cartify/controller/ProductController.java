package com.ecom.cartify.controller;

import com.ecom.cartify.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.ProductApi;
import org.openapitools.model.ProductDTO;
import org.openapitools.model.ProductRegisterDTO;
import org.openapitools.model.ProductUpdateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductDTO> registerProduct(ProductRegisterDTO productRegisterDTO) {
        log.info("Inventory quantity: {}", productRegisterDTO.getInventory().getQuantity());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(
                        "Product Created Successfully",
                        productService.createProduct(productRegisterDTO))
        );
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(Long productId, ProductUpdateDTO productUpdateDTO) {
        return ResponseEntity.ok(new ProductDTO(
                "Product Updated Successfully",
                productService.updateProductById(productId, productUpdateDTO))
        );
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(Long productId) {
        return ResponseEntity.ok(new ProductDTO(
                "Product Found Successfully",
                productService.getProductById(productId))
        );
    }

    @Override
    public ResponseEntity<ProductDTO> deleteProductById(Long productId) {
        return ResponseEntity.ok(new ProductDTO(
                "Product Deleted Successfully",
                productService.deleteProductById(productId))
        );
    }
}
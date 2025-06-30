package com.ecom.cartify.service.impl;

import com.ecom.cartify.mapper.GlobalMapper;
import com.ecom.cartify.repositry.ProductRepositry;
import com.ecom.cartify.repositry.SellerRepositry;
import com.ecom.cartify.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.ProductDataDTO;
import org.openapitools.model.ProductRegisterDTO;
import org.openapitools.model.ProductUpdateDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepositry  productRepositry;
    private final GlobalMapper mapper;

    @Override
    public ProductDataDTO createProduct(ProductRegisterDTO productRegisterDTO) {
        if (productRegisterDTO.getSellerId() == null) {
            throw new IllegalArgumentException("Seller ID must not be null"); }
        var productEntity = mapper.toProduct(productRegisterDTO);
        var inventory = productEntity.getInventory();
        inventory.setProduct(productEntity);
        var savedProduct = productRepositry.save(productEntity);
        return mapper.toProductDataDto(savedProduct);
    }

    @Override
    public ProductDataDTO updateProductById(Long productId, ProductUpdateDTO productUpdateDTO) {
        var existingProduct = productRepositry.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        mapper.toProductUpdate(productUpdateDTO, existingProduct);
        var updatedProduct = productRepositry.save(existingProduct);
        return mapper.toProductDataDto(updatedProduct);
    }

    @Override
    public ProductDataDTO getProductById(Long productId) {
        var product = productRepositry.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        return mapper.toProductDataDto(product);
    }

    @Override
    public ProductDataDTO deleteProductById(Long productId) {
        var existingProduct = productRepositry.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        productRepositry.delete(existingProduct);
        return mapper.toProductDataDto(existingProduct);
    }

}

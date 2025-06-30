package com.ecom.cartify.service;


import org.openapitools.model.*;

public interface ProductService {

    ProductDataDTO createProduct(ProductRegisterDTO productRegisterDTO);
    ProductDataDTO updateProductById(Long productId, ProductUpdateDTO productUpdateDTO);
    ProductDataDTO getProductById(Long productId);
    ProductDataDTO deleteProductById(Long productId);

}

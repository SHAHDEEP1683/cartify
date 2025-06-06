package com.ecom.cartify.service;


import org.openapitools.model.*;

public interface SellerService {

    SellerDataDTO createSeller(SellerRegisterDTO sellerRegisterDTO);
    SellerDataDTO updateSellerById(Long sellerId, SellerUpdateDTO sellerUpdateDTO);
    SellerDataDTO getSellerById(Long sellerId);
    SellerDataDTO deleteSellerById(Long sellerId);

}

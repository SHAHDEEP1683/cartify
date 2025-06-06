package com.ecom.cartify.service.impl;

import com.ecom.cartify.mapper.GlobalMapper;
import com.ecom.cartify.repositry.AddressRepositry;
import com.ecom.cartify.repositry.SellerRepositry;
import com.ecom.cartify.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.SellerDataDTO;
import org.openapitools.model.SellerRegisterDTO;
import org.openapitools.model.SellerUpdateDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepositry sellerRepositry;
    private final AddressRepositry addressRepositry;
    private final GlobalMapper mapper;


    @Override
    public SellerDataDTO createSeller(SellerRegisterDTO sellerRegisterDTO) {
        var sellerEntity = mapper.toSeller(sellerRegisterDTO);
        var addressEntity = mapper.toAddress(sellerRegisterDTO.getAddress());
        sellerEntity.setAddress(addressEntity);
        addressRepositry.save(addressEntity);
        var savedSeller = sellerRepositry.save(sellerEntity);
        return mapper.toSellerDataDto(savedSeller);
    }

    @Override
    public SellerDataDTO updateSellerById(Long sellerId, SellerUpdateDTO sellerUpdateDTO) {
        var existingSeller = sellerRepositry.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller Not Found With ID: " + sellerId));
        mapper.toSellererUpdate(sellerUpdateDTO, existingSeller);
        mapper.toAddressUpdate(sellerUpdateDTO.getAddress(), existingSeller.getAddress());
        var updatedSeller = sellerRepositry.save(existingSeller);
        return mapper.toSellerDataDto(updatedSeller);
    }

    @Override
    public SellerDataDTO getSellerById(Long sellerId) {
        var findSeller = sellerRepositry.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller Not Found With ID: " + sellerId));
        return mapper.toSellerDataDto(findSeller);
    }

    @Override
    public SellerDataDTO deleteSellerById(Long sellerId) {
        var existingSeller = sellerRepositry.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller Not Found With ID: " + sellerId));
        sellerRepositry.delete(existingSeller);
        var sellerAddress = existingSeller.getAddress();
        addressRepositry.delete(sellerAddress);
        return mapper.toSellerDataDto(existingSeller);
    }

}

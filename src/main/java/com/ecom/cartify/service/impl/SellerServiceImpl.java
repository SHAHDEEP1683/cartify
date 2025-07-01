package com.ecom.cartify.service.impl;

import com.ecom.cartify.constant.RoleType;
import com.ecom.cartify.entity.Roles;
import com.ecom.cartify.mapper.GlobalMapper;
import com.ecom.cartify.repositry.AddressRepositry;
import com.ecom.cartify.repositry.RoleRepository;
import com.ecom.cartify.repositry.SellerRepositry;
import com.ecom.cartify.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.SellerDataDTO;
import org.openapitools.model.SellerRegisterDTO;
import org.openapitools.model.SellerUpdateDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepositry sellerRepositry;
    private final AddressRepositry addressRepositry;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final GlobalMapper mapper;


    @Override
    public SellerDataDTO createSeller(SellerRegisterDTO sellerRegisterDTO) {
        if (sellerRepositry.existsByEmail(sellerRegisterDTO.getEmail())) {
            log.warn("Seller with email {} already exists", sellerRegisterDTO.getEmail());
            throw new RuntimeException("Seller already exists");
        }
        try {
            String encodedPassword = passwordEncoder.encode(sellerRegisterDTO.getPassword());
            sellerRegisterDTO.setPassword(encodedPassword);

            var sellerEntity = mapper.toSeller(sellerRegisterDTO);
            var addressEntity = mapper.toAddress(sellerRegisterDTO.getAddress());
            sellerEntity.setAddress(addressEntity);
            addressRepositry.save(addressEntity);

            var savedSeller = sellerRepositry.save(sellerEntity);

            if (!roleRepository.existsByEmail(sellerRegisterDTO.getEmail())) {
                var role = Roles.of(sellerRegisterDTO.getEmail(), encodedPassword, RoleType.SELLER);
                roleRepository.save(role);
            }

            return mapper.toSellerDataDto(savedSeller);
        } catch (Exception e) {
            log.error("Error creating seller: {}", e.getMessage(), e);
            throw new RuntimeException("Seller creation failed");
        }
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

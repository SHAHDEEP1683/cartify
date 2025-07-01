package com.ecom.cartify.controller;

import com.ecom.cartify.service.RegistrationService;
import com.ecom.cartify.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.SellerApi;
import org.openapitools.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.spi.RegisterableService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SellerController implements SellerApi {

    private final SellerService sellerService;
    private final RegistrationService registrationService;

    @Override
    public ResponseEntity<SellerDTO> registerSeller(@RequestBody SellerRegisterDTO sellerRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new SellerDTO(
                "Seller Created",
                sellerService.createSeller(sellerRegisterDTO))
        );
    }

    @Override
    public ResponseEntity<AuthResponseDTO> authenticateSeller(LoginForm loginForm) {
        log.info("Authenticating Seller: {}", loginForm.getEmail());
        var authResponseDTO = registrationService.doAuthenticate(loginForm);
        log.info("User authentication successful for: {}", loginForm.getEmail());
        return ResponseEntity.ok(authResponseDTO);
    }

    @Override
    public ResponseEntity<SellerDTO> updateSeller(Long sellerId, SellerUpdateDTO sellerUpdateDTO) {
        return ResponseEntity.ok(new SellerDTO(
                " Seller Updated ",
                sellerService.updateSellerById(sellerId, sellerUpdateDTO)
        ));
    }

    @Override
    public ResponseEntity<SellerDTO> getSellerById(Long sellerId) {
        return ResponseEntity.ok(new SellerDTO(
                "Seller Found Successfully",
                sellerService.getSellerById(sellerId)
        ));
    }

    @Override
    public ResponseEntity<SellerDTO> deleteSellerById(Long sellerId) {
        return ResponseEntity.ok(new SellerDTO(
                "Seller Deleted Successfully",
                sellerService.deleteSellerById(sellerId)
        ));
    }

}

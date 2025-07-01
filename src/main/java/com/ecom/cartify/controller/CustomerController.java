package com.ecom.cartify.controller;

import com.ecom.cartify.service.CustomerService;
import com.ecom.cartify.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.CustomerApi;
import org.openapitools.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;
    private final RegistrationService registrationService;

    @Override
    public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody CustomerRegisterDTO customerRegisterDTO) {
            return ResponseEntity.status(HttpStatus.CREATED).body( new CustomerDTO(
                    "Cretaed ",
                    customerService.createCustomer(customerRegisterDTO))
            );
    }

    @Override
    public ResponseEntity<AuthResponseDTO> authenticateUser(LoginForm loginForm) {
        log.info("Authenticating user: {}", loginForm.getEmail());
        AuthResponseDTO authResponseDTO = registrationService.doAuthenticate(loginForm);
        log.info("User authentication successful for: {}", loginForm.getEmail());
        return ResponseEntity.ok(authResponseDTO);
    }

    @Override
    public ResponseEntity<CustomerDTO> updateCustomer(Long customerId,@RequestBody
    CustomerUpdateDTO customerUpdateDTO) {
        return ResponseEntity.ok(new CustomerDTO(
                "Customer Updated Successfully",
                customerService.updateCustomerById(customerId, customerUpdateDTO)
        ));
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(Long customerId) {
          return ResponseEntity.ok(new CustomerDTO(
                "Customer Found Successfully",
                  customerService.getCustomerById(customerId)
        ));

    }

    @Override
    public ResponseEntity<CustomerDTO> deleteCustomerById(Long customerId) {
        return ResponseEntity.ok(new CustomerDTO(
                "Customer Deleted Successfully",
                customerService.deleteCustomerById(customerId)

        ));
    }


}

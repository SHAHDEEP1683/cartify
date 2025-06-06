package com.ecom.cartify.controller;

import com.ecom.cartify.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CustomerApi;
import org.openapitools.model.CustomerDTO;
import org.openapitools.model.CustomerRegisterDTO;
import org.openapitools.model.CustomerUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody CustomerRegisterDTO customerRegisterDTO) {
            return ResponseEntity.status(HttpStatus.CREATED).body( new CustomerDTO(
                    "Cretaed ",
                    customerService.createCustomer(customerRegisterDTO))
            );
    }

    @Override
    public ResponseEntity<CustomerDTO> deleteCustomerById(Long customerId) {
        return ResponseEntity.ok(new CustomerDTO(
                "Customer Deleted Successfully",
                customerService.deleteCustomerById(customerId)

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
    public ResponseEntity<CustomerDTO> updateCustomer(Long customerId,@RequestBody
    CustomerUpdateDTO customerUpdateDTO) {
        return ResponseEntity.ok(new CustomerDTO(
                "Customer Updated Successfully",
                customerService.updateCustomerById(customerId, customerUpdateDTO)
        ));
    }
}

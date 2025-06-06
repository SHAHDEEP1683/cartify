package com.ecom.cartify.service;


import org.openapitools.model.CustomerDataDTO;
import org.openapitools.model.CustomerRegisterDTO;
import org.openapitools.model.CustomerUpdateDTO;

public interface CustomerService {

    CustomerDataDTO createCustomer(CustomerRegisterDTO customerRegisterDTO);
    CustomerDataDTO deleteCustomerById(Long customerId);
    CustomerDataDTO getCustomerById(Long customerId);
    CustomerDataDTO updateCustomerById(Long customerId, CustomerUpdateDTO customerUpdateDTO);
}

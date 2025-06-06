package com.ecom.cartify.service;


import org.openapitools.model.CustomerDataDTO;
import org.openapitools.model.CustomerRegisterDTO;
import org.openapitools.model.CustomerUpdateDTO;

public interface CustomerService {

    CustomerDataDTO createCustomer(CustomerRegisterDTO customerRegisterDTO);
    CustomerDataDTO updateCustomerById(Long customerId, CustomerUpdateDTO customerUpdateDTO);
    CustomerDataDTO getCustomerById(Long customerId);
    CustomerDataDTO deleteCustomerById(Long customerId);


}

package com.ecom.cartify.service.impl;

import com.ecom.cartify.constant.RoleType;
import com.ecom.cartify.entity.Roles;
import com.ecom.cartify.mapper.GlobalMapper;
import com.ecom.cartify.repositry.AddressRepositry;
import com.ecom.cartify.repositry.CustomerRepositry;
import com.ecom.cartify.repositry.RoleRepository;
import com.ecom.cartify.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openapitools.model.CustomerDataDTO;
import org.openapitools.model.CustomerRegisterDTO;
import org.openapitools.model.CustomerUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LogManager.getLogger(CustomerServiceImpl.class);
    private final CustomerRepositry customerRepositry;
    private final AddressRepositry addressRepositry;
    private final RoleRepository roleRepository;
    private final GlobalMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public CustomerDataDTO createCustomer(CustomerRegisterDTO customerRegisterDTO) {
        if (customerRepositry.existsByEmail(customerRegisterDTO.getEmail())) {
            log.warn("Customer with email {} already exists", customerRegisterDTO.getEmail());
            throw new RuntimeException("Customer already exists");
        }
        try {
            String encodedPassword = passwordEncoder.encode(customerRegisterDTO.getPassword());
            customerRegisterDTO.setPassword(encodedPassword);
            var customerEntity = mapper.toCustomer(customerRegisterDTO);
            var addressEntity = mapper.toAddress(customerRegisterDTO.getAddress());
            customerEntity.setAddress(addressEntity);
            addressRepositry.save(addressEntity);
            var savedCustomer = customerRepositry.save(customerEntity);

            if (!roleRepository.existsByEmail(customerRegisterDTO.getEmail())) {
                Roles role = Roles.of(customerRegisterDTO.getEmail(), encodedPassword, RoleType.CUSTOMER);
                roleRepository.save(role);
            }

            return mapper.toCustomerDataDto(savedCustomer);
        } catch (Exception e) {
            log.info("Error creating customer: {}", e.getMessage());
            throw new RuntimeException("Customer creation failed");
        }
    }


    @Override
    public CustomerDataDTO updateCustomerById(Long customerId, CustomerUpdateDTO customerUpdateDTO) {
        var exitingCustomer = customerRepositry.findById(customerId).orElseThrow(() -> new RuntimeException("Customer Not Found With : " + customerId));
        mapper.toCustomerUpdate(customerUpdateDTO, exitingCustomer);
        mapper.toAddressUpdate(customerUpdateDTO.getAddress(), exitingCustomer.getAddress());
        var updatedCustomer = customerRepositry.save(exitingCustomer);
        return mapper.toCustomerDataDto(updatedCustomer);
    }

    @Override
    public CustomerDataDTO getCustomerById(Long customerId) {
        var findCustomer = customerRepositry.findById(customerId).orElseThrow(() -> new RuntimeException("Customer Not Found With : " + customerId));
        return mapper.toCustomerDataDto(findCustomer);
    }


    @Override
    public CustomerDataDTO deleteCustomerById(Long customerId) {
        var exitingCustomer = customerRepositry.findById(customerId).orElseThrow(() -> new RuntimeException("Customer Not Found With : " + customerId));
        customerRepositry.delete(exitingCustomer);
        var customerAddress = exitingCustomer.getAddress();
        addressRepositry.delete(customerAddress);
        return mapper.toCustomerDataDto(exitingCustomer);
    }


}

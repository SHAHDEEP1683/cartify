package com.ecom.cartify.mapper;

import com.ecom.cartify.entity.Address;
import com.ecom.cartify.entity.Customer;
import org.mapstruct.*;
import org.openapitools.model.AddressDTO;
import org.openapitools.model.CustomerDataDTO;
import org.openapitools.model.CustomerRegisterDTO;
import org.openapitools.model.CustomerUpdateDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GlobalMapper {


    Customer toCustomer(CustomerRegisterDTO customerRegisterDTO);
    Address toAddress(AddressDTO addressDTO);
    CustomerDataDTO toCustomerDataDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerUpdate(CustomerUpdateDTO customerUpdateDTO, @MappingTarget Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toAddressUpdate(AddressDTO addressDTO,@MappingTarget Address address);
}

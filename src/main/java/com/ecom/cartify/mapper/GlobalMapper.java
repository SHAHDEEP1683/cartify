package com.ecom.cartify.mapper;

import com.ecom.cartify.entity.Address;
import com.ecom.cartify.entity.Customer;
import com.ecom.cartify.entity.Seller;
import org.mapstruct.*;
import org.openapitools.model.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GlobalMapper {


    Customer toCustomer(CustomerRegisterDTO customerRegisterDTO);
    CustomerDataDTO toCustomerDataDto(Customer customer);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerUpdate(CustomerUpdateDTO customerUpdateDTO, @MappingTarget Customer customer);

    Address toAddress(AddressDTO addressDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toAddressUpdate(AddressDTO addressDTO,@MappingTarget Address address);

    Seller toSeller(SellerRegisterDTO sellerRegisterDTO);
    SellerDataDTO toSellerDataDto(Seller seller);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toSellererUpdate(SellerUpdateDTO sellerUpdateDTO, @MappingTarget Seller seller);

}

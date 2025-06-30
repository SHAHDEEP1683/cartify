package com.ecom.cartify.mapper;

import com.ecom.cartify.entity.*;
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

    Product toProduct(ProductRegisterDTO productRegisterDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toProductUpdate(ProductUpdateDTO productUpdateDTO, @MappingTarget Product product);
    ProductDataDTO toProductDataDto(Product product);

    Inventory toInventory(InventoryDataDTO inventoryDataDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toInventoryUpdate(InventoryUpdateDTO inventoryUpdateDTO, @MappingTarget Inventory inventory);
    InventoryDataDTO toInventoryUpdateDto(Inventory inventory);

    @Mapping(target = "product.productId", source = "productId")
    @Mapping(target = "customer.customerId", source = "customerId")

    Order toOrder(OrderCreateDTO dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toOrderUpdate(OrderUpdateDTO dto, @MappingTarget Order entity);
    OrderDataDTO toOrderDataDto(Order entity);

}

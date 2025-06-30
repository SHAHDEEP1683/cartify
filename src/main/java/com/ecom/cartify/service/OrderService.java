package com.ecom.cartify.service;

import org.openapitools.model.OrderCreateDTO;
import org.openapitools.model.OrderDataDTO;
import org.openapitools.model.OrderUpdateDTO;

public interface OrderService {

    OrderDataDTO createOrder(OrderCreateDTO orderCreateDTO);
    OrderDataDTO updateOrderById(Long orderId, OrderUpdateDTO orderUpdateDTO);
    OrderDataDTO getOrderById(Long orderId);
    OrderDataDTO deleteOrderById(Long orderId);

}

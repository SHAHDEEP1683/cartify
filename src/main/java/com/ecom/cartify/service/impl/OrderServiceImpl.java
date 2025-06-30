package com.ecom.cartify.service.impl;

import com.ecom.cartify.constant.OrderStatus;
import com.ecom.cartify.mapper.GlobalMapper;
import com.ecom.cartify.repositry.OrderRepositry;
import com.ecom.cartify.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.OrderCreateDTO;
import org.openapitools.model.OrderDataDTO;
import org.openapitools.model.OrderUpdateDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepositry orderRepository;
    private final GlobalMapper mapper;

    @Override
    public OrderDataDTO createOrder(OrderCreateDTO orderCreateDTO) {
        var orderEntity = mapper.toOrder(orderCreateDTO);
        orderEntity.setOrderStatus(OrderStatus.PENDING);

        var savedOrder = orderRepository.save(orderEntity);
        return mapper.toOrderDataDto(savedOrder);
    }

    @Override
    public OrderDataDTO updateOrderById(Long orderId, OrderUpdateDTO orderUpdateDTO) {
        var existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        mapper.toOrderUpdate(orderUpdateDTO, existingOrder);
        var updatedOrder = orderRepository.save(existingOrder);
        return mapper.toOrderDataDto(updatedOrder);
    }

    @Override
    public OrderDataDTO getOrderById(Long orderId) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        return mapper.toOrderDataDto(order);
    }

    @Override
    public OrderDataDTO deleteOrderById(Long orderId) {
        var existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        orderRepository.delete(existingOrder);
        return mapper.toOrderDataDto(existingOrder);
    }

}

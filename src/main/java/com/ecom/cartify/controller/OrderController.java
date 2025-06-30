package com.ecom.cartify.controller;

import com.ecom.cartify.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.OrderApi;
import org.openapitools.model.OrderCreateDTO;
import org.openapitools.model.OrderDTO;
import org.openapitools.model.OrderUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<OrderDTO> createOrder(OrderCreateDTO orderCreateDTO) {
        log.info("Creating order for customerId: {}", orderCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OrderDTO(
                "Order Created Successfully",
                orderService.createOrder(orderCreateDTO))
        );
    }

    @Override
    public ResponseEntity<OrderDTO> updateOrder(Long orderId, OrderUpdateDTO orderUpdateDTO) {
        return ResponseEntity.ok(new OrderDTO(
                "Order Updated Successfully",
                orderService.updateOrderById(orderId, orderUpdateDTO))
        );
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(Long orderId) {
        return ResponseEntity.ok(new OrderDTO(
                "Order Retrieved Successfully",
                orderService.getOrderById(orderId))
        );
    }

    @Override
    public ResponseEntity<OrderDTO> deleteOrderById(Long orderId) {
        return ResponseEntity.ok(new OrderDTO(
                "Order Deleted Successfully",
                orderService.deleteOrderById(orderId))
        );
    }

}

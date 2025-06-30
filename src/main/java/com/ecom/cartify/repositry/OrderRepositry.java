package com.ecom.cartify.repositry;//package com.ecom.cartify.repositry;

import com.ecom.cartify.entity.Order;
import com.ecom.cartify.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrderRepositry extends JpaRepository<Order, Long> {
}

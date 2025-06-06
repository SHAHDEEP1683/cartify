package com.ecom.cartify.repositry;

import com.ecom.cartify.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CustomerRepositry extends JpaRepository<Customer, Long> {
}

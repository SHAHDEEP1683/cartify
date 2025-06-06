package com.ecom.cartify.repositry;

import com.ecom.cartify.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AddressRepositry extends JpaRepository<Address, Long> {
}

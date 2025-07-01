package com.ecom.cartify.repositry;//package com.ecom.cartify.repositry;

import com.ecom.cartify.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface AdminRepositry extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}

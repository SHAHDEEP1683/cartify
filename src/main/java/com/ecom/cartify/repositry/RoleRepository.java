package com.ecom.cartify.repositry;

import com.ecom.cartify.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByEmail(String email);
    boolean existsByEmail(String email);

}

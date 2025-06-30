package com.ecom.cartify.repositry;//package com.ecom.cartify.repositry;

import com.ecom.cartify.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface InventoryRepositry extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByProduct_ProductId(Long productId);

}

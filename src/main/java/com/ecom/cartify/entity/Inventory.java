package com.ecom.cartify.entity;//package com.ecom.cartify.entity;

import com.ecom.cartify.base.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Inventory extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;

    @NotNull
    private Long quantity;

    private Long sold;

    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;

}

package com.ecom.cartify.entity;//package com.ecom.cartify.entity;

import com.ecom.cartify.base.Audit;
import com.ecom.cartify.constant.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotNull
    private String productName;

    @NotNull
    private String productImage;

    @NotNull
    private Long productPrice;

    @NotNull
    private String productDescription;

    @Enumerated(EnumType.STRING)
    private Category productCategory;

    @NotNull
    private Long sellerId;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;

}
package com.ecom.cartify.entity;//package com.ecom.cartify.entity;

import com.ecom.cartify.base.Audit;
import com.ecom.cartify.constant.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotNull
    private String productName;

    @NotNull
    private Long productPrice;

    @NotNull
    private String productDescription;

    @Enumerated(EnumType.STRING)
    private Category productCategory;

    @OneToOne
    @JoinColumn(name = "sellerId")
    private Seller seller;

}

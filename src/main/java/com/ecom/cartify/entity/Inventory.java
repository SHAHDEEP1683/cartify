package com.ecom.cartify.entity;//package com.ecom.cartify.entity;
//
//import com.ecom.cartify.base.Audit;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//
//@Entity
//public class Inventory extends Audit {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    private Long quantity;
//
//    @NotNull
//    private Long sold;
//
//    @OneToOne
//    private Seller seller;
//
//    @OneToOne
//    private Product product;
//
//}

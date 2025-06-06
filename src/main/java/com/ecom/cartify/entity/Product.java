package com.ecom.cartify.entity;//package com.ecom.cartify.entity;
//
//import com.ecom.cartify.base.Audit;
//import com.ecom.cartify.constant.Category;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotNull;
//
//@Entity
//public class Product extends Audit {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    private String name;
//
//    @NotNull
//    private Long price;
//
//    @NotNull
//    private String description;
//
//    @Enumerated(EnumType.STRING)
//    private Category category;
//
//    @OneToOne
//    private Seller seller;
//
//}

package com.ecom.cartify.entity;//package com.ecom.cartify.entity;
//
//import com.ecom.cartify.base.Audit;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//
//@Entity
//public class Order extends Audit {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @OneToOne
//    private Product product;
//
//    @OneToOne
//    private Customer customer;
//
//    @OneToOne
//    private Payment payment;
//}
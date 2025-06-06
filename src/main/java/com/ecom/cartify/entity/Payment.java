package com.ecom.cartify.entity;//package com.ecom.cartify.entity;
//
//import com.ecom.cartify.base.Audit;
//import com.ecom.cartify.constant.PaymentStatus;
//import jakarta.persistence.*;
//
//@Entity
//public class Payment extends Audit {
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
//    @Enumerated(EnumType.STRING)
//    private PaymentStatus paymentStatus;
//
//
//}

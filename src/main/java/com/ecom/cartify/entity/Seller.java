package com.ecom.cartify.entity;//package com.ecom.cartify.entity;
//
//import com.ecom.cartify.base.Audit;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//
//@Entity
//public class Seller extends Audit {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    private String name;
//
//    @Pattern(
//            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
//            message = "Invalid email format"
//    )
//    private Email email;
//
//    @NotNull
//    private String password;
//
//    @Pattern(
//            regexp = "^[6-9]\\d{9}$",
//            message = "Invalid phone number. It should be a 10-digit number starting with 6-9."
//    )
//    private String phoneNumber;
//
//    @OneToOne
//    private Address address;
//
//}

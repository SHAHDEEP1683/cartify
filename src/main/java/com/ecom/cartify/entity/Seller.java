package com.ecom.cartify.entity;

import com.ecom.cartify.base.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Seller extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sellerId;

    @NotNull
    private String sellerName;

    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid email format")
    private String email;

    @NotNull
    private String password;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid phone number. It should be a 10-digit number starting with 6-9."
    )
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="addressId")
    private Address address;

}

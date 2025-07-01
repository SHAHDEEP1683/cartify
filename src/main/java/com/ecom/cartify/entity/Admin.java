package com.ecom.cartify.entity;

import com.ecom.cartify.base.Audit;
import com.ecom.cartify.constant.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;

    @NotNull
    private String name;

    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid email format"
    )
    private String email;

    @NotNull
    private String password;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid phone number. It should be a 10-digit number starting with 6-9."
    )
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private RoleType role = RoleType.ADMIN;

}

package com.ecom.cartify.entity;

import com.ecom.cartify.constant.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "Roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private RoleType role;

        @Column(nullable = false)
        private String password;

        @Column(unique = true, nullable = false, length = 100)
        private String email;

    public static Roles of(String email, String encodedPassword, RoleType roleType) {
        return Roles.builder()
                .email(email)
                .password(encodedPassword)
                .role(roleType)
                .build();
    }
}
package com.ecom.cartify.entity;

import com.ecom.cartify.base.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String state;


}

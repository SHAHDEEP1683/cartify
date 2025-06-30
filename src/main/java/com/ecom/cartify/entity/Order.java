package com.ecom.cartify.entity;

import com.ecom.cartify.base.Audit;
import com.ecom.cartify.constant.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "createdAt", column = @Column(name = "orderDateTime"))
public class Order extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @NotNull
    private Long quantity;

    @NotNull
    private Long totalAmount;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shippingAddressId")
    private Address shippingAddress;

}

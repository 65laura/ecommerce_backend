package com.onlineshopping.trial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID cartId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartItem> items = new ArrayList<>();
    @Column
    private Double totalPrice;
}

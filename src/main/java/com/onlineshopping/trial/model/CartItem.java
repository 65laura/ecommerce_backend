package com.onlineshopping.trial.model;

import com.onlineshopping.trial.products.model.Products;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "cart-item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    private Products product;

    private Integer quantity;

    @ManyToOne
    private Cart cart;
}

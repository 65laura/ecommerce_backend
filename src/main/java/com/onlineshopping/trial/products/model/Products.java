package com.onlineshopping.trial.products.model;
import com.onlineshopping.trial.enums.EProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID productId;
    @Column
    private String productName;
    @Column
    private EProductCategory productCategory;
    @Column
    private double price;
    @Transient
    private double discountedPrice;
    @Column
    private String description;


}

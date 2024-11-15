package com.onlineshopping.trial.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID categoryId;
    @Column
    private String categoryName;
    public enum ECategoryType{
       WOMEN,
        MEN,
        KIDS,
        DRESSES,HOME,BEAUTY,ELECTRONICS,BOTTOMS,
        TOPS,BAGS,JEWELRY,ACCESSORIES
    };
    @Enumerated(EnumType.STRING)
    private ECategoryType categoryType;

}

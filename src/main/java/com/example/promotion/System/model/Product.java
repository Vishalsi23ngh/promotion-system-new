package com.example.promotion.System.model;

import com.example.promotion.System.Enums.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    User user;

    String name;

    String description;

    @Enumerated(EnumType.STRING)
    ProductType productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<Promotions> promotions = new ArrayList<>();

    int noOfLikes ;

    String comments;

    int noOfClicks;

    int noOfPurchasedProduct;


}

package com.example.promotion.System.model;

import com.example.promotion.System.Enums.ProductType;
import com.example.promotion.System.Enums.Promotion_Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Promotions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer promotionId;


    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    @JsonIgnore
    Product product;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    User user;

    String description;

    Date start_date;

    Date end_date;

    @Enumerated(EnumType.STRING)
    Promotion_Type promotion_type;

    ProductType productType;

    Double rating;

    Integer likes = 0;

    int clicks = 0;

}


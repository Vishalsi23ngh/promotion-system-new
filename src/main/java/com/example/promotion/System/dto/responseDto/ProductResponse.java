package com.example.promotion.System.dto.responseDto;

import com.example.promotion.System.Enums.ProductType;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponse {
    Integer productId;

    String name;

    String description;

    ProductType productType;

    int noOfLikes;

    String comments;

    int noOfClicks;

    int noOfPurchasedProduct;
}

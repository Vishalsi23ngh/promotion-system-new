package com.example.promotion.System.dto.responseDto;

import com.example.promotion.System.Enums.ProductType;
import com.example.promotion.System.Enums.Promotion_Type;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PromotionsResponse{

    Integer promotionId;

    Integer productId;

    Integer userId;

    String description;

    Date start_date;

    Date end_date;

    Promotion_Type promotion_type;

    ProductType productType;

    double rating;

    int likes;
}

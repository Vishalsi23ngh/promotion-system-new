package com.example.promotion.System.dto.requestDto;

import com.example.promotion.System.Enums.ProductType;
import com.example.promotion.System.Enums.Promotion_Type;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PromotionRequest {

    Integer userId;

    Integer productId;

    String description;

    Date start_date;

    Date end_date;

    Promotion_Type promotion_type;

    ProductType productType;

}

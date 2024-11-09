package com.example.promotion.System.dto.responseDto;

import com.example.promotion.System.Enums.ProductType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserHistoryResponse {

   String description;

   ProductType productType;
}

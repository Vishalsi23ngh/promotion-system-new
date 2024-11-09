package com.example.promotion.System.dto.requestDto;

import com.example.promotion.System.Enums.ProductType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductRequest {

    Integer userId;

    String name;

    String description;

    ProductType productType;


}

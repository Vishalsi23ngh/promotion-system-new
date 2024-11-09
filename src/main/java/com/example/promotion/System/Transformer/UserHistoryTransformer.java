package com.example.promotion.System.Transformer;

import com.example.promotion.System.dto.responseDto.UserHistoryResponse;
import com.example.promotion.System.model.Product;
import com.example.promotion.System.model.Promotions;
import com.example.promotion.System.model.User;
import com.example.promotion.System.model.UserHistory;

import java.time.LocalDateTime;

public class UserHistoryTransformer {

    public static UserHistory userHistoryRequestToUserHistory(User user, Product product){
        return UserHistory.builder()
                .user(user)
                .product(product)
                .productType(product.getProductType())
                .interactionTime(LocalDateTime.now())
                .build();
    }

    public static UserHistoryResponse userHistoryToUserHistoryResponse(Promotions promotions){
        return UserHistoryResponse.builder()
                .productType(promotions.getProduct().getProductType())
                .description(promotions.getDescription())
                .build();
    }
}

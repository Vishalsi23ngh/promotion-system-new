package com.example.promotion.System.Transformer;


import com.example.promotion.System.dto.requestDto.PromotionRequest;
import com.example.promotion.System.dto.responseDto.PromotionsResponse;
import com.example.promotion.System.model.Product;
import com.example.promotion.System.model.Promotions;
import com.example.promotion.System.model.User;

public class PromotionTransformer {
    public static Promotions promotionsRequestToPromotion(PromotionRequest promotionRequest , Product product, User user){
        return  Promotions.builder()
                .user(user)
                .product(product)
                .promotion_type(promotionRequest.getPromotion_type())
                .description(promotionRequest.getDescription())
                .start_date(promotionRequest.getStart_date())
                .end_date(promotionRequest.getEnd_date())
                .productType(promotionRequest.getProductType())
                .build();
    }

    public  static PromotionsResponse promotionToPromotionResponse(Promotions promotions){
       return PromotionsResponse.builder()
               .promotionId(promotions.getPromotionId())
               .productId(promotions.getProduct().getProductId())
               .userId((promotions.getUser().getUserId()))
               .description(promotions.getDescription())
               .start_date(promotions.getStart_date())
               .end_date(promotions.getEnd_date())
               .promotion_type(promotions.getPromotion_type())
               .productType(promotions.getProductType())
               .build();
    }
}

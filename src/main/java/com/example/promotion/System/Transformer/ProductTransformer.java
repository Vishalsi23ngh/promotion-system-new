package com.example.promotion.System.Transformer;


import com.example.promotion.System.dto.requestDto.ProductRequest;
import com.example.promotion.System.dto.responseDto.ProductResponse;
import com.example.promotion.System.model.Product;
import com.example.promotion.System.model.User;

public class ProductTransformer {
    public static Product productRequestToProduct(ProductRequest productRequest, User user) {
        return Product.builder()
                .user(user)
                .name(productRequest.getName())
                .productType(productRequest.getProductType())
                .description(productRequest.getDescription())
                .build();
    }

    public static ProductResponse productToProductResponse(Product savedProduct) {

        return ProductResponse.builder()
                .productId(savedProduct.getProductId())
                .name(savedProduct.getName())
                .productType(savedProduct.getProductType())
                .description(savedProduct.getDescription())
                .build();
    }
}

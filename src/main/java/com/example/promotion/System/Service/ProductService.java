package com.example.promotion.System.Service;


import com.example.promotion.System.Enums.UserType;
import com.example.promotion.System.Exceptions.InvalidUserTypeException;
import com.example.promotion.System.Repository.ProductRepository;
import com.example.promotion.System.Repository.UserRepository;
import com.example.promotion.System.Transformer.ProductTransformer;
import com.example.promotion.System.dto.requestDto.ProductRequest;
import com.example.promotion.System.dto.responseDto.ProductResponse;
import com.example.promotion.System.model.Product;
import com.example.promotion.System.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private  final ProductRepository productRepository;

    private  final UserRepository userRepository;
    public ProductResponse addProduct(ProductRequest productRequest) {

        if (productRequest == null) {
            throw new IllegalArgumentException("ProductRequest must not be null");
        }
        if (productRequest.getUserId() == null) {
            throw new IllegalArgumentException("UserId must not be null in ProductRequest");
        }

        Optional<User> optionalUser = userRepository.findById(productRequest.getUserId());

        if(optionalUser.isEmpty()){
            throw  new InvalidUserTypeException("User not found");
        }

        User user = optionalUser.get();
        UserType userType = user.getUserType();

        if(userType.equals(UserType.BUSINESS_USER)){
            Product product = ProductTransformer.productRequestToProduct(productRequest ,user);
            Product savedProduct = productRepository.save(product);
            return ProductTransformer.productToProductResponse(savedProduct);
        }else{
            throw  new InvalidUserTypeException("Only Business_USer can add product");
        }

    }


    public String addLikes(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        Product product;
        if(optionalProduct.isPresent()){
            product = optionalProduct.get();
            product.setNoOfLikes(product.getNoOfLikes() + 1);
            productRepository.save(product);
        }else{
            return  "product with this id does not exist";
        }

        return  "like added to product successfully";
    }

    public String addClicks(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setNoOfClicks(product.getNoOfClicks() + 1);
            productRepository.save(product);
        }else{
            return "product with this id does not exist";
        }
        return "click added successfully";
    }

    public ProductResponse updateProduct(ProductRequest productRequest, int productId) {
        Optional<User> optionalUser = userRepository.findById(productRequest.getUserId());

        User user = optionalUser.get();
        if(user.getUserType() != UserType.BUSINESS_USER){
            throw  new InvalidUserTypeException("only business user can update the product information");
        }

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new RuntimeException(" no product exist with this id please enter valid product id");
        }

        // updating the product
        Product savedProduct = optionalProduct.get();
        savedProduct.setProductType(productRequest.getProductType());
        savedProduct.setName(productRequest.getName());
        savedProduct.setDescription(productRequest.getDescription());

        productRepository.save(savedProduct);

        return ProductTransformer.productToProductResponse(savedProduct);
    }

    public List<Product> getProcuctList() {
        List<Product> products = productRepository.findAll();
        List<Product> newList = new ArrayList<>();
        for(Product product : products){
            if(product.getNoOfLikes()> 10 && product.getNoOfClicks() >100){
                newList.add(product);
            }
        }
        return  newList;
    }
//
//    public Product addComments(int productId) {
//    }
}

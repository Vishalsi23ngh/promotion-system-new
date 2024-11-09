package com.example.Promotion.Management.System.Service;

import com.example.Promotion.Management.System.Enums.ProductType;
import com.example.Promotion.Management.System.Exceptions.UserNotExistException;
import com.example.Promotion.Management.System.Repository.ProductRepository;
import com.example.Promotion.Management.System.Repository.PromotionRepository;
import com.example.Promotion.Management.System.Repository.UserHistoryRepository;
import com.example.Promotion.Management.System.Repository.UserRepository;
import com.example.Promotion.Management.System.Transformer.UserHistoryTransformer;
import com.example.Promotion.Management.System.dto.requestDto.UserHistoryRequest;
import com.example.Promotion.Management.System.model.Product;
import com.example.Promotion.Management.System.model.User;
import com.example.Promotion.Management.System.model.UserHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserHistoryService {

    private  final UserHistoryRepository userHistoryRepository;

    private  final UserRepository userRepository;

    private  final PromotionRepository promotionRepository;

    private  final  ProductRepository productRepository;



    public String addUserHistory(UserHistoryRequest userHistoryRequest) {

        // Retrieve user and product (promotion) entities
        User user = userRepository.findById(userHistoryRequest.getUserId())
                .orElseThrow(() -> new UserNotExistException("User with this id does not exist"));

        Product product = productRepository.findById(userHistoryRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product (promotion) not found with this id: " + userHistoryRequest.getProductId()));

        // Transform request to UserHistory entity
        UserHistory history = UserHistoryTransformer.userHistoryRequestToUserHistory(user, product);

        // Add history to user's existing histories list
        user.getUserHistories().add(history);

        // Save the history, which should cascade to user if needed
        userHistoryRepository.save(history);

        return "History is added with productId: " + history.getProduct().getProductId() + " and userId: " + history.getUser().getUserId();
    }






    public List<UserHistory> getPromotionBasedOnPastHistory(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw  new RuntimeException("no user exist with this id");
        }
        User user = optionalUser.get();

        List<UserHistory> userHistories = user.getUserHistories();

        return userHistories;
    }


    public String addPurchasedItemToHistory(int userId, int productId) {
        //checking that user already exist or not
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw  new UserNotExistException("no user exist with the userId: " + userId);
        }
        User user = optionalUser.get();

        // checking for the product is present or not
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new RuntimeException("product is not found with this productId : " + productId);
        }

        Product product = optionalProduct.get();

        UserHistory orderHistory = UserHistoryTransformer.userHistoryRequestToUserHistory(user, product);
        orderHistory.setPurchased(true);

        return "History created";

    }
}

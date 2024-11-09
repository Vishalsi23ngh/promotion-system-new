package com.example.promotion.System.Transformer;

import com.example.promotion.System.dto.requestDto.UserRequest;
import com.example.promotion.System.dto.responseDto.UserResponse;
import com.example.promotion.System.model.User;

public class UserTransformer {

    public  static User userRequestToUser(UserRequest userRequest){

        return  User.builder()
                .name(userRequest.getName())
                .age((userRequest.getAge()))
                .address(userRequest.getAddress())
                .gender((userRequest.getGender()))
                .userType(userRequest.getUserType())
                .profession(userRequest.getProfession())
                .emailId(userRequest.getEmailId())
                .password(userRequest.getPassword())
                .build();
    }

    public  static UserResponse userToUserResponse(User user){
        return UserResponse.builder()
                .name(user.getName())
                .address(user.getAddress())
                .gender(user.getGender())
                .age(user.getAge())
                .profession(user.getProfession())
                .userType(user.getUserType())
                .emailId(user.getEmailId())
                .build();
    }
}

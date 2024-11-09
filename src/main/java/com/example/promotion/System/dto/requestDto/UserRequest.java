package com.example.promotion.System.dto.requestDto;


import com.example.promotion.System.Enums.Gender;
import com.example.promotion.System.Enums.Profession;
import com.example.promotion.System.Enums.UserType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    String name;

    String password;

    String emailId;

    String address;

    int age;

    Gender gender;

    Profession profession;

    UserType userType;

}

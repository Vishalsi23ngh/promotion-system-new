package com.example.promotion.System.dto.responseDto;

import com.example.promotion.System.Enums.Gender;
import com.example.promotion.System.Enums.Profession;
import com.example.promotion.System.Enums.UserType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponse {
    String name;

    String emailId;

    String address;

    int age;

    Gender gender;

    Profession profession;

    UserType userType;
}

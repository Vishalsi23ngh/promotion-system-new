package com.example.promotion.System.model;

import com.example.promotion.System.Enums.Gender;
import com.example.promotion.System.Enums.Profession;
import com.example.promotion.System.Enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "users")
public class User {

    String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;

    String password;

    @Column(unique = true , nullable = false)
    String emailId;

    String address;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    Profession profession;

    @Enumerated(EnumType.STRING)
    UserType userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    List<Promotions> promotionId;

    boolean liked = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<Product> products;

    @OneToMany(fetch = FetchType.LAZY)
    List<UserHistory> userHistories;

}

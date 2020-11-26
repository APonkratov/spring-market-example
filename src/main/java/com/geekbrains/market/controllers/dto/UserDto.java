package com.geekbrains.market.controllers.dto;

import lombok.Data;

@Data
public class UserDto {
    private String phone;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private UserType userType;
}

package com.geekbrains.market.controllers;

import com.geekbrains.market.controllers.dto.UserDto;
import com.geekbrains.market.controllers.dto.UserType;
import com.geekbrains.market.entities.User;
import com.geekbrains.market.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping
    public List<User> getAllUsers(@RequestParam(value = "type", required = false) UserType type) {
        return userService.getAllUsersWithType(type);
    }
}

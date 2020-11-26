package com.geekbrains.market.services;

import com.geekbrains.market.controllers.dto.UserDto;
import com.geekbrains.market.controllers.dto.UserType;
import com.geekbrains.market.entities.Role;
import com.geekbrains.market.entities.User;
import com.geekbrains.market.exceptions.UnknownUserTypeException;
import com.geekbrains.market.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public User saveUser(UserDto userDto) {
        if (userDto.getUserType().equals(UserType.MANAGER)) {
            saveManger(userDto);
        } else if (userDto.getUserType().equals(UserType.USER)) {
            saveGeneralUser(userDto);
        }

        throw new UnknownUserTypeException();
    }

    private User saveManger(UserDto userDto) {
        User user = createUserFromDto(userDto);

        Role role = roleService.findByName("ROLE_MANAGER");
        user.setRoles(List.of(role));

        return userRepository.save(user);

    }

    private User saveGeneralUser(UserDto userDto) {
        User user = createUserFromDto(userDto);
        return userRepository.save(user);
    }

    private User createUserFromDto(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setAge(userDto.getAge());

        return user;
    }

    public List<User> getAllUsersWithType(UserType type) {

        Role role;

        switch (type) {
            case USER:
                role = roleService.findByName("ROLE_USER");
                return userRepository.findAllByRoles(role);
            case MANAGER:
                role = roleService.findByName("ROLE_MANAGER");
                return userRepository.findAllByRoles(role);
            default:
                return userRepository.findAll();
        }
    }

}

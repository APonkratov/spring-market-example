package com.geekbrains.market.repositories;

import com.geekbrains.market.entities.Role;
import com.geekbrains.market.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    List<User> findAllByRoles(Role role);

}

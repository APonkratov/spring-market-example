package com.geekbrains.market.repositories;

import com.geekbrains.market.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();

    Optional<Role> findByName(String name);

}

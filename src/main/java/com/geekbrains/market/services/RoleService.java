package com.geekbrains.market.services;

import com.geekbrains.market.entities.Role;
import com.geekbrains.market.exceptions.RoleNotFoundException;
import com.geekbrains.market.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        Optional<Role> roleOptional = roleRepository.findByName(name);

        if (roleOptional.isPresent()) {
            return roleOptional.get();
        } else {
            throw new RoleNotFoundException(String.format("Роль с именем %s не найдена.", name));
        }
    }

}

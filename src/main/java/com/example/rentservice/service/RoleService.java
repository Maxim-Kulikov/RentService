package com.example.rentservice.service;

import com.example.rentservice.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {
    List<Role> getAll();

    Optional<Role> get(Short id);

    Optional<Role> get(String name);
}

package com.example.rentservice.repository.role;

import com.example.rentservice.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    Optional<Role> findFirstById(Short id);

    Optional<Role> findFirstByRole(String role);
}
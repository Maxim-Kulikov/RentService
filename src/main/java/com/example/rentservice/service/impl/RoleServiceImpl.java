package com.example.rentservice.service.impl;

import com.example.rentservice.model.Role;
import com.example.rentservice.repository.role.RoleDao;
import com.example.rentservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleDao roleDao;

    @Transactional
    public List<Role> getAll() {
        return (List<Role>) roleDao.findAll();
    }

    @Transactional
    public Optional<Role> get(Short id) {
        return roleDao.findFirstById(id);
    }

    @Transactional
    public Optional<Role> get(String name) {
        return roleDao.findFirstByRole(name);
    }
}

package com.example.rentservice.mapper.role;

import com.example.rentservice.dto.role.RoleResp;
import com.example.rentservice.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResp toRoleResponse(Role role);
}


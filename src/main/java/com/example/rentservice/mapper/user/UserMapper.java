package com.example.rentservice.mapper.user;

import com.example.rentservice.dto.user.UserAuthReq;
import com.example.rentservice.dto.user.UserExistedResp;
import com.example.rentservice.model.Role;
import com.example.rentservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserAuthReq dto);

    @Mapping(target = "role", source = "role")
    @Mapping(target = "id", source = "dto.id")
    User toUser(UserExistedResp dto, Role role);

    @Mapping(target = "role", source = "role.role")
    UserExistedResp toUserExistedResp(User user);

    List<UserExistedResp> toUserExistedList(List<User> users);
}

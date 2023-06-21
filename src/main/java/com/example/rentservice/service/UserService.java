package com.example.rentservice.service;

import com.example.rentservice.dto.user.UserAuthReq;
import com.example.rentservice.dto.user.UserExistedResp;
import com.example.rentservice.dto.user.UserUpdateReq;
import com.example.rentservice.exception.UserIsExistedException;
import com.example.rentservice.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserExistedResp> getAll();

    UserExistedResp save(UserAuthReq dto) throws UserIsExistedException;

    void delete(Long id) throws UserNotFoundException;

    UserExistedResp findByLogin(String login) throws UserNotFoundException;

    UserExistedResp update(UserUpdateReq dto, Long id) throws UserNotFoundException;

    UserExistedResp getExistedUser(Long id) throws UserNotFoundException;
}

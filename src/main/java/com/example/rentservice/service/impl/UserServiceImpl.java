package com.example.rentservice.service.impl;

import com.example.rentservice.dto.user.UserAuthReq;
import com.example.rentservice.dto.user.UserExistedResp;
import com.example.rentservice.dto.user.UserUpdateReq;
import com.example.rentservice.exception.RoleNotFoundException;
import com.example.rentservice.exception.UserIsExistedException;
import com.example.rentservice.exception.UserNotFoundException;
import com.example.rentservice.mapper.user.UserMapper;
import com.example.rentservice.model.ExtraUserData;
import com.example.rentservice.model.Role;
import com.example.rentservice.model.User;
import com.example.rentservice.repository.role.RoleDao;
import com.example.rentservice.repository.user.UserDao;
import com.example.rentservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final Short ROLE_ADMIN_ID = 1;
    private final Short ROLE_USER_ID = 2;
    @Autowired
    private final UserDao userDao;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final RoleDao roleDao;

    @Override
    @Transactional
    public List<UserExistedResp> getAll() {
        return userMapper.toUserExistedList((List<User>) userDao.findAll());
    }

    @Override
    @Transactional
    public UserExistedResp save(UserAuthReq dto) throws UserIsExistedException {
        if (getOptionalOfUser(dto.getLogin()).isEmpty()) {
            return Optional.of(dto)
                    .map(userMapper::toUser)
                    .map(this::setRole)
                    .map(this::setEmptyExtraUserData)
                    .map(userDao::save)
                    .map(userMapper::toUserExistedResp)
                    .orElseThrow(() -> new RuntimeException("Could not save user!"));
        }
        throw new UserIsExistedException(dto.getLogin());
    }

    @Transactional
    @Override
    public void delete(Long id) throws UserNotFoundException {
        if (!userDao.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public UserExistedResp findByLogin(String login) throws UserNotFoundException {
        User user = getUserOrThrowException(login);
        return userMapper.toUserExistedResp(user);
    }

    @Override
    @Transactional
    public UserExistedResp update(UserUpdateReq dto, Long id) throws UserNotFoundException {
        User user = getUserOrThrowException(id);
        user = updateUserWithChanger(user, dto);
        userDao.save(user);
        return userMapper.toUserExistedResp(user);
    }

    @Override
    @Transactional
    public UserExistedResp getExistedUser(Long id) throws UserNotFoundException {
        User user = getUserOrThrowException(id);
        return userMapper.toUserExistedResp(user);
    }

    private User setRole(User user) {
        user.setRole(findRole(ROLE_USER_ID));
        return user;
    }

    private User setEmptyExtraUserData(User user) {
        user.setExtraUserData(new ExtraUserData());
        return user;
    }

    private Role findRole(Short id) {
        return roleDao.findFirstById(id)
                .orElseThrow(() -> new RuntimeException("Error during getting of role"));
    }

    public User updateUserWithChanger(User model, UserUpdateReq dto) {
        return model.changer()
                .login(dto.getLogin())
                .password(dto.getPassword())
                .role(model.getRole())
                .extraUserData(model.getExtraUserData())
                .change();
    }

    private Optional<User> getOptionalOfUser(String login) {
        return userDao.findFirstByLogin(login);
    }

    private Optional<User> getOptionalOfUser(Long id) {
        return userDao.findById(id);
    }

    private Optional<User> getOptionalOfUser(String login, String password) {
        return userDao.findFirstByLoginAndPassword(login, password);
    }

    private User getUserOrThrowException(Long id) throws UserNotFoundException {
        return getOptionalOfUser(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private User getUserOrThrowException(String login) throws UserNotFoundException {
        return getOptionalOfUser(login)
                .orElseThrow(() -> new UserNotFoundException(login));
    }
}

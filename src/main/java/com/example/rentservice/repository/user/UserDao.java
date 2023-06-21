package com.example.rentservice.repository.user;

import com.example.rentservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findFirstByLoginAndPassword(String login, String password);

    Optional<User> findFirstByLogin(String login);
}

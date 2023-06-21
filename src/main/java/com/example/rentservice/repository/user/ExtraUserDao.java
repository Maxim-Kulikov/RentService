package com.example.rentservice.repository.user;

import com.example.rentservice.model.ExtraUserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExtraUserDao extends CrudRepository<ExtraUserData, Long> {
    Optional<ExtraUserData> findFirstByPassportNumber(String passportNumber);
}

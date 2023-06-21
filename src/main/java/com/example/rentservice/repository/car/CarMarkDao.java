package com.example.rentservice.repository.car;

import com.example.rentservice.model.CarMark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarMarkDao extends CrudRepository<CarMark, Integer> {
    Optional<CarMark> findCarMarkByMark(String mark);

    Boolean existsCarMarkByMark(String mark);
}

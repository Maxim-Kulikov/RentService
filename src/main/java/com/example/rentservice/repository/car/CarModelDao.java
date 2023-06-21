package com.example.rentservice.repository.car;

import com.example.rentservice.model.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelDao extends CrudRepository<CarModel, Integer> {
    Optional<CarModel> findCarModelByModelAndMark_Mark(String model, String mark);

    Optional<CarModel> findCarModelByModel(String model);

    Boolean existsCarModelByModel(String model);

    Boolean existsCarModelByModelAndMark_Mark(String model, String mark);
}

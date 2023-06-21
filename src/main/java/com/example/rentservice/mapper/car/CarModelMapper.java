package com.example.rentservice.mapper.car;

import com.example.rentservice.model.CarMark;
import com.example.rentservice.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarModelMapper {
    @Mapping(target = "mark", source = "carMark")
    @Mapping(target = "id", ignore = true)
    CarModel toCarModel(String model, CarMark carMark);
}

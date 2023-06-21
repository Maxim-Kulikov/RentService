package com.example.rentservice.mapper.car;

import com.example.rentservice.model.CarMark;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMarkMapper {
    CarMark toCarMark(String mark);
}

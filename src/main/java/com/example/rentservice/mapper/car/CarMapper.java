package com.example.rentservice.mapper.car;

import com.example.rentservice.dto.car.CarCreateReq;
import com.example.rentservice.dto.car.CarDescriptionResp;
import com.example.rentservice.dto.car.CarInfoResp;
import com.example.rentservice.model.Car;
import com.example.rentservice.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.ui.Model;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "mark", source = "carModel.mark.mark")
    @Mapping(target = "model", source = "carModel.model")
    CarInfoResp toCarPresentationDto(Car car);

    @Mapping(target = "carNumber", source = "dto.number")
    @Mapping(target = "carModel", source = "carModel")
    @Mapping(target = "id", ignore = true)
    Car toCar(CarCreateReq dto, CarModel carModel);

    @Mapping(target = "mark", source = "carModel.mark.mark")
    @Mapping(target = "model", source = "carModel.model")
    CarDescriptionResp toCarDescriptionResp(Car car);

    List<CarInfoResp> toListCarPresentation(List<Car> cars);

    List<CarDescriptionResp> toListCarDescription(List<Car> cars);

    @Mapping(target = "id", source = "dto.id")
    Car toCar(CarDescriptionResp dto, CarModel carModel);
}

package com.example.rentservice.service;

import com.example.rentservice.dto.car.*;
import com.example.rentservice.exception.CarNotFoundException;
import com.example.rentservice.exception.MarkNotFoundException;
import com.example.rentservice.exception.ModelNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    CarInfoResp getCarPresentation(Integer id);

    List<CarInfoResp> getAllCarsPresentation(CarFilterReq filter);

    List<CarDescriptionResp> getAllCarsDescription(CarFilterReq filter);

    CarDescriptionResp getCarDescription(Integer id);

    CarDescriptionResp update(CarUpdateReq dto, Integer id) throws MarkNotFoundException, ModelNotFoundException;

    CarDescriptionResp save(CarCreateReq dto) throws MarkNotFoundException, ModelNotFoundException;

    void delete(Integer id) throws CarNotFoundException;
}

package com.example.rentservice.controller.car;

import com.example.rentservice.dto.car.*;
import com.example.rentservice.exception.CarNotFoundException;
import com.example.rentservice.exception.MarkNotFoundException;
import com.example.rentservice.exception.ModelNotFoundException;
import com.example.rentservice.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cars", description = "CRUD operations with cars")
@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private final CarService carService;

    @Operation(
            summary = "Car description",
            description = "Returns detailed car description by car id"
    )
    @GetMapping("/description/{id}")
    public CarDescriptionResp getDescription(@PathVariable @Parameter(description = "Car id")
                                             Integer id) {
        return carService.getCarDescription(id);
    }

    @Operation(
            summary = "Cars presentation",
            description = "Returns short cars description and filter it by params from request"
    )
    @GetMapping("/presentation")
    public List<CarInfoResp> getAllPresentation(
            @Parameter(description = "Parameters for cars filtering")
            CarFilterReq filter) {
        return carService.getAllCarsPresentation(filter);
    }

    @Operation(
            summary = "Cars description",
            description = "Returns detailed cars description and filter it by params from request"
    )
    @GetMapping("/description")
    public List<CarDescriptionResp> getAllDescription(
            @Parameter(description = "Parameters for cars filtering")
            CarFilterReq filter) {
        return carService.getAllCarsDescription(filter);
    }

    @Operation(
            summary = "Save car",
            description = "Saves car and returns detailed description of this car"
    )
    @PostMapping("/save")
    public CarDescriptionResp save(@RequestBody @Parameter(description = "Data for car saving")
                                   CarCreateReq dto)
            throws MarkNotFoundException, ModelNotFoundException {
        return carService.save(dto);
    }

    @Operation(
            summary = "Update car",
            description = "Updates car and returns detailed description of this car"
    )
    @PatchMapping("/update/{id}")
    public CarDescriptionResp update(@RequestBody @Parameter(description = "Data for car updating")
                                     CarUpdateReq dto,
                                     @PathVariable @Parameter(description = "Car id")
                                     Integer id)
            throws MarkNotFoundException, ModelNotFoundException {
        return carService.update(dto, id);
    }

    @Operation(
            summary = "Delete car",
            description = "Deletes car"
    )
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable @Parameter(description = "Car id")
                       Integer id) throws CarNotFoundException {
        carService.delete(id);
    }

    @Operation(
            summary = "Car presentation",
            description = "Returns short car description by car id"
    )
    @GetMapping("/presentation/{id}")
    public CarInfoResp getPresentation(@PathVariable @Parameter(description = "Car id")
                                       Integer id) {
        return carService.getCarPresentation(id);
    }

}

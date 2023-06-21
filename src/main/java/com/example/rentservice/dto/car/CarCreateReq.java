package com.example.rentservice.dto.car;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Params for car creation")
public class CarCreateReq {
    @Schema(description = "Car mark")
    private String mark;
    @Schema(description = "Car model")
    private String model;
    @Schema(description = "Car price")
    private Integer price;
    @Schema(description = "Car license plate")
    private String number;
    @Schema(description = "Id of image for car")
    private String idImage;
    @Schema(description = "Car limitations")
    private String limitations;
}

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
@Schema(description = "Params for car updating")
public class CarUpdateReq {
    @Schema(description = "Car mark")
    private String mark;
    @Schema(description = "Car model")
    private String model;
    @Schema(description = "Car license plate")
    private String carNumber;
    @Schema(description = "Car price")
    private Integer price;
    @Schema(description = "Car limitations")
    private String limitations;
    @Schema(description = "Image id for car")
    private String idImage;
}

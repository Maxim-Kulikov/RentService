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
@Schema(description = "Short info about car")
public class CarInfoResp {
    @Schema(description = "Car id")
    private Integer id;
    @Schema(description = "Car mark")
    private String mark;
    @Schema(description = "Car model")
    private String model;
    @Schema(description = "Image id for car")
    private String idImage;
}

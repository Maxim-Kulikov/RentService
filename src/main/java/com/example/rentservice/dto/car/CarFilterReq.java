package com.example.rentservice.dto.car;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Params for car filtering")
public class CarFilterReq {
    @Schema(description = "Ids of marks")
    private ArrayList<Integer> idMarks;
    @Schema(description = "Ids of models")
    private ArrayList<Integer> idModels;
    @Schema(description = "Minimal price of car")
    private Integer minPrice;
    @Schema(description = "Maximal price of car")
    private Integer maxPrice;
    @Schema(description = "Name of field for sorting (mark, model, price)")
    private String sortField;
    @Schema(description = "Name of sort order (asc, desc)")
    private String sortOrder;
}

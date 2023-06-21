package com.example.rentservice.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Params for order creation")
public class OrderCreateReq {
    @Schema(description = "Date of starting of rent")
    private Date startDate;
    @Schema(description = "Date of finishing of rent")
    private Date finishDate;
    @Schema(description = "Client id")
    private Long idUser;
    @Schema(description = "Car id")
    private Integer idCar;
}

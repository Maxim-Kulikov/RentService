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
@Schema(description = "Data about order")
public class OrderResp {
    @Schema(description = "Order id")
    private Long id;
    @Schema(description = "Date of starting of rent")
    private Date startDate;
    @Schema(description = "Date of finishing of rent")
    private Date finishDate;
    @Schema(description = "Status of order (allowed or not)")
    private Boolean status;
    @Schema(description = "Car id")
    private Integer idCar;
    @Schema(description = "Client id")
    private Long idUser;
    @Schema(description = "Admin id (who allowed or not)")
    private Long idAdmin;
    @Schema(description = "Refuse reason (if admin did not allow)")
    private String refuseReason;
    @Schema(description = "Total cost")
    private Long price;
}

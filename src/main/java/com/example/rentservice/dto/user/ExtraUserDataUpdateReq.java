package com.example.rentservice.dto.user;

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
@Schema(description = "Params for updating of additional info about user")
public class ExtraUserDataUpdateReq {
    @Schema(description = "User passport number")
    private String passportNumber;
    @Schema(description = "User name")
    private String name;
    @Schema(description = "User lastname")
    private String lastname;
    @Schema(description = "User birthdate")
    private Date birthdate;
    @Schema(description = "User number of driving license")
    private String drivingLicense;
    @Schema(description = "User phone number")
    private String phone;
    @Schema(description = "Register date of user driving license")
    private Date registerDate;
}

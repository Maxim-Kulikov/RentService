package com.example.rentservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Params for user authorization")
public class UserAuthReq {
    @Schema(description = "User login")
    private String login;
    @Schema(description = "User password")
    private String password;
}

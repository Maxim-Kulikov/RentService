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
@Schema(description = "Short info about user")
public class UserExistedResp {
    @Schema(description = "User id")
    private Long id;
    @Schema(description = "User login")
    private String login;
    @Schema(description = "User role (admin or user)")
    private String role;
}

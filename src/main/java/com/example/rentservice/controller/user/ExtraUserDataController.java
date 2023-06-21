package com.example.rentservice.controller.user;

import com.example.rentservice.dto.user.ExtraUserDataResp;
import com.example.rentservice.dto.user.ExtraUserDataUpdateReq;
import com.example.rentservice.service.ExtraUserDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Additional users data", description = "Updating and reading of users additional data")
@RestController
@AllArgsConstructor
@RequestMapping("/users/extra-data")
public class ExtraUserDataController {
    @Autowired
    private final ExtraUserDataService extraUserDataService;

    @Operation(
            summary = "Update additional user data",
            description = "Updates additional user data and returns it"
    )
    @PatchMapping("/update/{id}")
    public ExtraUserDataResp update(@RequestBody @Parameter(description = "Data for updating")
                                    ExtraUserDataUpdateReq dto,
                                    @PathVariable @Parameter(description = "User id") Long id) {
        return extraUserDataService.update(dto, id);
    }

    @Operation(
            summary = "Get additional user data",
            description = "Returns additional user data"
    )
    @GetMapping("/{id}")
    public ExtraUserDataResp get(@PathVariable @Parameter(description = "User id")
                                 Long id) {
        return extraUserDataService.get(id);
    }

    @Operation(
            summary = "Get additional users data",
            description = "Returns additional users data"
    )
    @GetMapping()
    public List<ExtraUserDataResp> get() {
        return extraUserDataService.getAll();
    }
}

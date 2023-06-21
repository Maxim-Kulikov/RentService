package com.example.rentservice.controller.user;

import com.example.rentservice.dto.user.UserAuthReq;
import com.example.rentservice.dto.user.UserExistedResp;
import com.example.rentservice.dto.user.UserUpdateReq;
import com.example.rentservice.exception.UserIsExistedException;
import com.example.rentservice.exception.UserNotFoundException;
import com.example.rentservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "CRUD operations with users")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(
            summary = "Get user",
            description = "Returns user data"
    )
    @GetMapping("/{id}")
    public UserExistedResp get(@PathVariable @Parameter(description = "User id")
                               Long id) throws UserNotFoundException {
        return userService.getExistedUser(id);
    }

    @Operation(
            summary = "Get users",
            description = "Returns users data"
    )
    @GetMapping("")
    public List<UserExistedResp> get() {
        return userService.getAll();
    }

    @Operation(
            summary = "Save user",
            description = "Saves new user to database and returns login and role"
    )
    @PostMapping("/save")
    public UserExistedResp save(@RequestBody @Parameter(description = "Data for user saving")
                                UserAuthReq dto) throws UserIsExistedException {
        String login = dto.getLogin();
        String password = dto.getPassword();
        if (login == null || password == null || login.isBlank() || password.isBlank()) {
            throw new RuntimeException("User could not be saved, empty password or login");
        }
        return userService.save(dto);
    }

    @Operation(
            summary = "Delete user",
            description = "Deletes user"
    )
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable @Parameter(description = "User id") Long id) throws UserNotFoundException {
        userService.delete(id);
    }

    @Operation(
            summary = "Update user",
            description = "Updates user"
    )
    @PatchMapping("/update/{id}")
    public UserExistedResp update(@RequestBody @Parameter(description = "Data for user updating")
                                  UserUpdateReq dto,
                                  @PathVariable @Parameter(description = "User id")
                                  Long id) throws UserNotFoundException {
        return userService.update(dto, id);
    }

}

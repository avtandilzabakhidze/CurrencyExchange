package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.User;
import com.example.currencyexchange.dto.UserDTO;
import com.example.currencyexchange.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public Iterable<User> getUser() {
        return service.getUser();
    }

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return service.addUser(userDTO);
    }
}

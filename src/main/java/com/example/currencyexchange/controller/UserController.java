package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.User;
import com.example.currencyexchange.dto.UserDTO;
import com.example.currencyexchange.service.UserService;
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

    @GetMapping
    public Iterable<User> getUser() {
        return service.getUser();
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return service.addUser(userDTO);
    }
}

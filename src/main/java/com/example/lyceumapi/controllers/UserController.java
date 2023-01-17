package com.example.lyceumapi.controllers;

import com.example.lyceumapi.dto.UserDto;
import com.example.lyceumapi.entity.User;
import com.example.lyceumapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("save")
    public User save(@RequestBody UserDto user) {
        return service.save(user);
    }

    @GetMapping("getAll")
    public List<User> getAll() {
        return service.getAll();
    }
}



package com.jayklef.bhis.controller;

import com.jayklef.bhis.model.User;
import com.jayklef.bhis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("")
    public User getUser(){
        return userService.getUser();
    }
}

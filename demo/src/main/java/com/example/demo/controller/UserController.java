package com.example.demo.controller;

import com.example.demo.entity.AuthRequest;
import com.example.demo.entity.SendJsonToUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public SendJsonToUser generateToken(@RequestBody AuthRequest authRequest) throws Exception {
       return userService.getToken(authRequest);
    }
}

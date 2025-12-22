package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password) {
        return authService.login(email, password);
    }
}

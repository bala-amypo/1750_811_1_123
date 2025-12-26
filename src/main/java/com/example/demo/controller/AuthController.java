package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Employee login(@RequestParam String email) {
        return employeeService.findByEmail(email)
                .orElseThrow(() -> new com.example.demo.exception.ResourceNotFoundException("User not found with email: " + email));
    }
}

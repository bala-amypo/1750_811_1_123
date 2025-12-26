package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.dto.AuthResponseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final EmployeeService employeeService;
    private final JwtTokenProvider tokenProvider;

    public AuthController(EmployeeService employeeService, JwtTokenProvider tokenProvider) {
        this.employeeService = employeeService;
        this.tokenProvider = tokenProvider;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        Employee employee = employeeService.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "email", request.getEmail()));

        // Here you can add password validation if you store passwords
        // For demo purposes, we assume email existence is sufficient

        String token = tokenProvider.generateToken(employee.getId(), employee.getEmail(), "USER");
        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(token);
        response.setEmail(employee.getEmail());
        response.setUserId(employee.getId());
        response.setRole("USER");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

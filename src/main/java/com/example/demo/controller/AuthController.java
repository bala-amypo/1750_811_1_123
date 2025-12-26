package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final EmployeeRepository employeeRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(EmployeeRepository employeeRepository,
                          JwtTokenProvider jwtTokenProvider) {
        this.employeeRepository = employeeRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String email = request.get("email");

        Employee emp = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        String token = jwtTokenProvider.generateToken(
                emp.getId(),
                emp.getEmail(),
                "USER"
        );

        return ResponseEntity.ok(Map.of("token", token));
    }
}

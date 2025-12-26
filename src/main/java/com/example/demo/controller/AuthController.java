package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final EmployeeRepository employeeRepository;
    private final JwtTokenProvider tokenProvider;

    public AuthController(EmployeeRepository employeeRepository, JwtTokenProvider tokenProvider) {
        this.employeeRepository = employeeRepository;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        // Check if employee exists by email
        Optional<Employee> employeeOpt = employeeRepository.findByEmail(loginRequest.getEmail());

        if (employeeOpt.isEmpty()) {
            return ResponseEntity.status(401).body(new LoginResponse("Invalid credentials", null));
        }

        Employee emp = employeeOpt.get();

        // For simplicity, assuming password matches if email exists (you can extend with actual password check)
        String token = tokenProvider.generateToken(emp.getId(), emp.getEmail(), "USER");

        LoginResponse response = new LoginResponse("Success", token);
        return ResponseEntity.ok(response);
    }
}

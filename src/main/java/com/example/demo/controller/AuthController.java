package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(EmployeeRepository employeeRepository,
                          PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ===== REGISTER =====
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Employee employee) {

        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setRole(employee.getRole() == null ? "USER" : employee.getRole());

        employeeRepository.save(employee);
        return ResponseEntity.ok("User registered successfully");
    }

    // ===== LOGIN =====
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Employee request) {

        Employee employee = employeeRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        return ResponseEntity.ok("Login successful");
    }
}

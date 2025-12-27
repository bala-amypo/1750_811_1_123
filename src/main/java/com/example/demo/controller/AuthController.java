package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final EmployeeRepository employeeRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(EmployeeRepository employeeRepository,
                          JwtTokenProvider jwtTokenProvider) {
        this.employeeRepository = employeeRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /* ================= REGISTER ================= */

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        Optional<Employee> existing =
                employeeRepository.findByEmail(request.getEmail());

        if (existing.isPresent()) {
            return ResponseEntity.badRequest()
                    .body("Email already registered");
        }

        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employee.setRole(
                request.getRole() != null ? request.getRole() : "USER"
        );
        employee.setActive(true);

        employeeRepository.save(employee);

        return ResponseEntity.ok("User registered successfully");
    }

    /* ================= LOGIN ================= */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Employee employee = employeeRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                employee.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = jwtTokenProvider.generateToken(
                employee.getId(),
                employee.getEmail(),
                employee.getRole()
        );

        return ResponseEntity.ok(token);
    }
}

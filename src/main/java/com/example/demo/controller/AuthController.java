package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final EmployeeRepository employeeRepository;

    public AuthController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Signup new employee
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(employee.getEmail());

        if (existingEmployee.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already registered");
        }

        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Signup successful");
    }

    // Login employee
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);

        if (employee.isPresent()) {
            // Simple password check (store encrypted in real apps)
            if (employee.get().getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }
    }
}

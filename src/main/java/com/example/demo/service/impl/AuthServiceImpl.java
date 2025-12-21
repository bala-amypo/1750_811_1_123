package com.example.demo.service.impl;

import com.example.demo.security.JwtTokenProvider;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(AuthRegisterRequest request) {
        // Create a new user
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        // Save user to DB
        User savedUser = userRepository.save(user);

        // Generate JWT token
        String token = jwtService.generateToken(savedUser);

        // Return AuthResponse
        return new AuthResponse(
                savedUser.getId(),     // Long ID
                savedUser.getEmail(),  // String email
                savedUser.getRole(),   // String role
                token                  // String token
        );
    }

    @Override
    public AuthResponse login(AuthLoginRequest request) {
        // Find user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        String token = jwtService.generateToken(user);

        // Return AuthResponse
        return new AuthResponse(
                user.getId(),         // Long ID
                user.getEmail(),      // String email
                user.getRole(),       // String role
                token                 // String token
        );
    }
}

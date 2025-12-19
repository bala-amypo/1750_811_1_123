package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
public String register(@RequestBody AuthRegisterRequest request) {

    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    user.setEmail(request.getEmail());

    return authService.register(user);
}



    @PostMapping("/login")
public String login(@RequestBody AuthLoginRequest request) {
    return authService.login(
            request.getUsername(),
            request.getPassword()
    );
}

}

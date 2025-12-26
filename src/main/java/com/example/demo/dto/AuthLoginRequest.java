package com.example.demo.dto;

public class AuthLoginRequest {

    private String email;

    public AuthLoginRequest() {
    }

    public AuthLoginRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

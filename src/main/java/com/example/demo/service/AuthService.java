package com.example.demo.service;

import com.example.demo.entity.User;

public interface AuthService {

    User login(String email, String password);
}

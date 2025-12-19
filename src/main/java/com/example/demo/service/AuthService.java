package com.example.demo.service;

import com.example.demo.model.User;

public interface AuthService {

    String register(User user);

    String login(String username, String password);
}

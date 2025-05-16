package com.taskify.user_management.service;

import com.taskify.user_management.dto.requests.LoginRequest;
import com.taskify.user_management.dto.requests.RegisterRequest;
import com.taskify.user_management.dto.responses.TokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

        TokenResponse register(RegisterRequest request);
        TokenResponse login(LoginRequest request);

    }


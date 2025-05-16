package com.taskify.user_management.service;

import com.taskify.user_management.dto.requests.LoginRequest;
import com.taskify.user_management.dto.requests.RegisterRequest;
import com.taskify.user_management.dto.responses.TokenResponse;
import com.taskify.user_management.enums.RoleType;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.repository.UserRepositry;
import com.taskify.user_management.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
        private final UserRepositry userRepositry;
        private final JwtUtil jwtUtil;
        private final PasswordEncoder passwordEncoder;


    @Override
    public TokenResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getName());
        user.setEmail(request.getEmail());
        user.setPass(passwordEncoder.encode(request.getPassword()));
        user.setRole(RoleType.MANAGER);

        user = userRepositry.save(user);

        System.out.println(user);

        String token= jwtUtil.generateToken(user);
        return TokenResponse.builder().token(token).build();
    }

    @Override
    public TokenResponse login(LoginRequest request) {
        User user= userRepositry.findByEmail(request.getEmail());
        if(user==null) {
            throw new RuntimeException("User not found!");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credentials!");
        }

        String token= jwtUtil.generateToken(user);
        return TokenResponse.builder().token(token).build();
    }

}

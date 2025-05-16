package com.taskify.user_management.controller;

import com.taskify.user_management.dto.requests.LoginRequest;
import com.taskify.user_management.dto.requests.RegisterRequest;
import com.taskify.user_management.dto.responses.GlobalResponse;
import com.taskify.user_management.dto.responses.TokenResponse;
import com.taskify.user_management.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-management/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping ("register")
    public ResponseEntity<GlobalResponse<TokenResponse>> register(@RequestBody @Valid RegisterRequest req){
        TokenResponse Dto= authService.register(req);
        GlobalResponse<TokenResponse> response= new GlobalResponse<>(HttpStatus.OK.value(),Dto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("login")
    ResponseEntity<GlobalResponse<TokenResponse>> authenticate(@RequestBody @Valid LoginRequest authReq){
        TokenResponse Dto= authService.login(authReq);
        GlobalResponse<TokenResponse> response= new GlobalResponse<>(HttpStatus.OK.value(),Dto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}

package com.taskify.user_management.service;

import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.enums.RoleType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.net.http.HttpRequest;
import java.util.List;

public interface UserService {


    UserResponse getUserById(Long id);
    RoleType getRoleByUserId(Long id);
    UserResponse deleteUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse getUserByEmail(String email);
}

package com.taskify.user_management.service;

import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.enums.RoleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    UserResponse getUserById(Long id);
    RoleType getRoleByUserId(Long id);
    UserResponse deleteUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse getUserByEmail(String email);




}

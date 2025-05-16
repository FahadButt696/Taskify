package com.taskify.user_management.service;

import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.enums.RoleType;
import com.taskify.user_management.exception.ResourceNotFoundException;
import com.taskify.user_management.mapper.UserMapper;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepositry userRepositry;

    @Override
    public UserResponse getUserById(Long id) {
        User user= userRepositry.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public RoleType getRoleByUserId(Long id) {
        RoleType user= userRepositry.findRoleByUserId(id);
        if(user==null) {
            throw new ResourceNotFoundException("Role", "id", id);
        }
        return user;
    }
    @Override
    public UserResponse deleteUserById(Long id) {
        User user = userRepositry.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        userRepositry.delete(user);
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> user= userRepositry.findAll();
        if(user.isEmpty()){
            throw new RuntimeException("User list is empty!");
        }
        return user.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByEmail(String email) {

        User user= userRepositry.findByEmail(email);

        if(user==null){
            throw new RuntimeException("User not found!");
        }
        return UserMapper.mapToUserDto(user);
    }

}

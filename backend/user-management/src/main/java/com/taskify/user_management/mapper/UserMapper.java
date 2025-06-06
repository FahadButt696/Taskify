package com.taskify.user_management.mapper;

import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.entity.User;

public class UserMapper {

    public static UserResponse mapToUserDto(User user) {
        return new UserResponse(user.getName(), user.getEmail(),user.getPassword());
    }

}

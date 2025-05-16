package com.taskify.user_management.dto.responses;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    @NotEmpty(message = "name must not me empty!")
    private String name;
    @Email(message = "email should be in email format!(abc@xyz.com)")
    @NotEmpty(message = "Email is required!")
    private String email;
    @NotEmpty(message = "Password is required!")
    private String password;
}
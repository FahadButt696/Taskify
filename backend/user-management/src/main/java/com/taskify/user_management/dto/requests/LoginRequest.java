package com.taskify.user_management.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
public class LoginRequest {
    @Email(message = "email should be in email format!(abc@xyz.com)")
    @NotEmpty(message = "Email is required!")
    private String email;
    @NotEmpty(message = "Password is required!")
    private String password;
}

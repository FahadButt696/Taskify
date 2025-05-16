package com.taskify.user_management.dto.requests;

import com.taskify.user_management.enums.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty(message = "name must not me empty!")
    private String name;
    @Email(message = "email should be in email format!(abc@xyz.com)")
    @NotEmpty(message = "Email is required!")
    private String email;
    @NotEmpty(message = "Password is required!")
    private String password;

    private RoleType role;

}

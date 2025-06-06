package com.taskify.user_management.dto.responses;

import com.taskify.user_management.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgRes {

    @NotEmpty(message = "Organization is required!")
    private String name;
}

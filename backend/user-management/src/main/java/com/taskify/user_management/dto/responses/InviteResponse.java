package com.taskify.user_management.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InviteResponse {
    private String email;
    private Long org_id;
    private String token;
}



package com.taskify.user_management.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InviteRequest {
        private String email;
        private Long organizationId;
    }

}

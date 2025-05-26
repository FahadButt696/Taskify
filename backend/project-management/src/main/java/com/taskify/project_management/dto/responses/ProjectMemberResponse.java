package com.taskify.project_management.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProjectMemberResponse {

    private Long userId;
    private LocalDateTime invitedAt;

}

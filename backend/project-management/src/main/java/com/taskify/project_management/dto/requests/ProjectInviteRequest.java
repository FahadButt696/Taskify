package com.taskify.project_management.dto.requests;

import lombok.Data;
import java.util.List;

@Data
public class ProjectInviteRequest {
    private Long projectId;
    private Long ownerId;
    private List<Long> userIdsToInvite;

}


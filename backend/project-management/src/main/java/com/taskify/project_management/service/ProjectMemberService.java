package com.taskify.project_management.service;

import com.taskify.project_management.dto.requests.ProjectInviteRequest;
import com.taskify.project_management.dto.responses.ProjectMemberResponse;

import java.util.List;

public interface ProjectMemberService {

        List<ProjectMemberResponse> inviteMembers(ProjectInviteRequest request);
        List<ProjectMemberResponse> getMembers(Long projectId);
}

package com.taskify.project_management.service;

import com.taskify.project_management.dto.requests.ProjectInviteRequest;
import com.taskify.project_management.dto.responses.ProjectMemberResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberService {

        List<ProjectMemberResponse> inviteMembers(ProjectInviteRequest request);
        List<ProjectMemberResponse> getMembersByProjectId(Long projectId);
        ProjectMemberResponse deleteMember(Long projectId, Long userId);

}

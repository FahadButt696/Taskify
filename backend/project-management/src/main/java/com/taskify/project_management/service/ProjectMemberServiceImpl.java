//package com.taskify.project_management.service;
//
//import com.taskify.project_management.dto.requests.ProjectInviteRequest;
//import com.taskify.project_management.dto.responses.ProjectMemberResponse;
//import com.taskify.project_management.entity.Project;
//import com.taskify.project_management.entity.ProjectMember;
//import com.taskify.project_management.exception.ProjectNotFoundException;
//import com.taskify.project_management.repository.ProjectMemberRepository;
//import com.taskify.project_management.repository.ProjectRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ProjectMemberServiceImpl implements ProjectMemberService {
//
//
//    private final ProjectRepository projectRepository;
//    private final ProjectMemberRepository memberRepository;
//
//    public ProjectMemberServiceImpl(ProjectRepository projectRepository, ProjectMemberRepository memberRepository) {
//        this.projectRepository = projectRepository;
//        this.memberRepository = memberRepository;
//    }
////    private final RabbitMQPublisher rabbitMQPublisher;
//
//    @Override
//    public List<ProjectMemberResponse> inviteMembers(ProjectInviteRequest request) {
//        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
//                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));
//
//        if (!project.getOwnerId().equals(request.getOwnerId())) {
//            throw new AccessDeniedException("Only the project owner can invite members");
//        }
//
//        List<ProjectMemberResponse> responses = new ArrayList<>();
//        for (Long userId : request.getUserIdsToInvite()) {
//            if (memberRepository.findByProjectIdAndUserId(project.getId(), userId)) continue;
//
//            ProjectMember member = new ProjectMember();
//            member.setProject(project);
//            member.setUserId(userId);
//            member.setInvitedAt(LocalDateTime.now());
//
//            memberRepository.save(member);
//            responses.add(new ProjectMemberResponse(userId, member.getInvitedAt()));
//
//            // Publish RabbitMQ event
////            rabbitMQPublisher.sendProjectMemberInvitedMessage(project.getId(), userId);
//        }
//        return responses;
//    }
//
//    @Override
//    public List<ProjectMemberResponse> getMembersByProjectId(Long projectId) {
//        return memberRepository.findByProjectId(projectId).stream()
//                .map(member -> new ProjectMemberResponse(member.getUserId(), member.getInvitedAt()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ProjectMemberResponse deleteMember(Long projectId, Long userId) {
//        return null;
//    }
//}
//}

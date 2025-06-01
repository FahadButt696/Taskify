package com.taskify.project_management.service;


import com.taskify.project_management.dto.requests.ProjectRequestDto;
import com.taskify.project_management.dto.responses.ProjectResponseDto;
import com.taskify.project_management.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
        ProjectResponseDto createProject(String token, Project request);
        List<ProjectResponseDto> getProjectsByOwner(String token);
        ProjectResponseDto getProjectById(Long id);
        ProjectResponseDto updateProjectById(Long id, Project request);
        ProjectResponseDto deleteProjectById(Long id);

}

package com.taskify.project_management.service;


import com.taskify.project_management.dto.requests.ProjectRequestDto;
import com.taskify.project_management.dto.responses.ProjectResponseDto;
import com.taskify.project_management.entity.Project;

import java.util.List;

public interface ProjectService {
        ProjectResponseDto create(Project request);
        List<ProjectResponseDto> getProjectsByOwner(Long ownerId);
        ProjectResponseDto getById(Long id);
        ProjectResponseDto update(Long id, ProjectRequestDto request);
        void delete(Long id);

}

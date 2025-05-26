package com.taskify.project_management.mapper;

import com.taskify.project_management.dto.responses.ProjectResponseDto;
import com.taskify.project_management.entity.Project;

public class projectMapper {

    public static ProjectResponseDto mapToDto(Project project) {
        return new ProjectResponseDto(project.getId(), project.getName(), project.getDescription(), project.getCreatedByUserEmail());
    }
}
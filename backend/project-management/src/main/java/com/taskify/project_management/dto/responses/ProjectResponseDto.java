package com.taskify.project_management.dto.responses;
// Step 6: DTOs for Project Creation

import lombok.Data;

@Data
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private String createdBy; // Name or email returned via Feign client
}


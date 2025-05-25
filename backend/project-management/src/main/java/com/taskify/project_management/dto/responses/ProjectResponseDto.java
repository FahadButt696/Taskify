package com.taskify.project_management.dto.responses;
// Step 6: DTOs for Project Creation

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private Long createdBy; // Name or email returned via Feign client
}


package com.taskify.project_management.dto.responses;

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
    private String createdByEmail; // Name or email returned via Feign client
}


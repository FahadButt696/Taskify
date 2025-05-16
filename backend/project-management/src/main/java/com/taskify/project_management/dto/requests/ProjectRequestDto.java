package com.taskify.project_management.dto.requests;

import lombok.Data;

@Data
public class ProjectRequestDto {

    private String name;
    private String description;
    private Long userId;
}

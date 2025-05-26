package com.taskify.project_management.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDto {

    private String name;
    private String description;
    private String CreatorEmail;
}

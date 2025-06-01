package com.taskify.project_management.controller;

import com.taskify.project_management.dto.responses.GlobalResponse;
import com.taskify.project_management.dto.responses.ProjectResponseDto;
import com.taskify.project_management.entity.Project;
import com.taskify.project_management.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create-project")
    public ResponseEntity<GlobalResponse<ProjectResponseDto>> createProject(@RequestHeader("Authorization")String token,@Valid @RequestBody Project request) {
        GlobalResponse<ProjectResponseDto> globalResponse = new GlobalResponse<>();
        try {
            ProjectResponseDto projectResponseDto = projectService.createProject(token, request);
            globalResponse.setStatusCode(HttpStatus.OK.value());
            globalResponse.setData(projectResponseDto);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(globalResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get-allProjects-by-owner")
    public ResponseEntity<GlobalResponse<List<ProjectResponseDto>>> getProjectsByOwner(@RequestHeader("Authorization")String token) {
        GlobalResponse<List<ProjectResponseDto>> globalResponse = new GlobalResponse<>();
        try{
            List<ProjectResponseDto> projectResponseDto= projectService.getProjectsByOwner(token);
            globalResponse.setStatusCode(HttpStatus.OK.value());
            globalResponse.setData(projectResponseDto);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(globalResponse, HttpStatus.OK);
    }

    @GetMapping("get-project-by-id/{id}")
    public ResponseEntity<GlobalResponse<ProjectResponseDto>> getProjectById(@PathVariable @Valid Long id) {
        GlobalResponse<ProjectResponseDto> globalResponse = new GlobalResponse<>();
        try{
            ProjectResponseDto projectResponseDto = projectService.getProjectById(id);
            globalResponse.setStatusCode(HttpStatus.OK.value());
            globalResponse.setData(projectResponseDto);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return new ResponseEntity<>(globalResponse, HttpStatus.OK);
    }

    @PutMapping("update-project-by-id/{id}")
    public ResponseEntity<GlobalResponse<ProjectResponseDto>> updateProject(@Valid @PathVariable Long id,@Valid @RequestBody Project request) {
        GlobalResponse<ProjectResponseDto> globalResponse = new GlobalResponse<>();

        try{
            ProjectResponseDto projectResponseDto= projectService.updateProjectById(id, request);
            globalResponse.setStatusCode(HttpStatus.OK.value());
            globalResponse.setData(projectResponseDto);

        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(globalResponse, HttpStatus.OK);

    }

    @DeleteMapping("delete-project-by-id/{id}")
    public ResponseEntity<GlobalResponse<ProjectResponseDto>> delete(@PathVariable @Valid Long id) {
        GlobalResponse<ProjectResponseDto> globalResponse = new GlobalResponse<>();
        try{
            ProjectResponseDto projectResponseDto= projectService.deleteProjectById(id);
            globalResponse.setStatusCode(HttpStatus.OK.value());
            globalResponse.setData(projectResponseDto);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return new ResponseEntity<>(globalResponse, HttpStatus.OK);
    }
}

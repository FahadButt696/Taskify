package com.taskify.project_management.service;

import com.taskify.project_management.dto.responses.ProjectResponseDto;
import com.taskify.project_management.entity.Project;
import com.taskify.project_management.feign.UserClient;
import com.taskify.project_management.mapper.projectMapper;
import com.taskify.project_management.repository.ProjectRepository;
import com.taskify.project_management.security.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;
    private final UserClient userClient;
    private final JwtUtil jwtUtil;
//    private final RabbitMQProd publisher;
//    private final RedisTemplate<String, Object> redisTemplate;

    public ProjectServiceImpl(ProjectRepository repository, /*RedisTemplate<String, Object> redisTemplate*/UserClient userClient, JwtUtil jwtUtil) {
        this.repository = repository;
//        this.redisTemplate = redisTemplate;
        this.userClient = userClient;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ProjectResponseDto createProject(String token,Project request) {
        Project project = new Project();
        try{
            Claims claims= jwtUtil.extractAllClaims(token);
            String email= claims.getSubject();
            project.setCreatedByUserEmail(email);
            project.setDescription(request.getDescription());
            project.setName(request.getName());
            project.setKey(request.getKey());
            project.setAccess(request.getAccess());
            project.setTemplate(request.getTemplate());

            Project saved = repository.save(project);


            return projectMapper.mapToDto(saved);
            // publish message
//            publisher.sendProjectCreatedMessage(saved);
        }
        catch (Exception e){
            throw new RuntimeException("Error creating project", e);

        }


    }

    @Override
    public List<ProjectResponseDto> getProjectsByOwner(String token) {

        try {
            Claims claims = jwtUtil.extractAllClaims(token);
            String email= claims.getSubject();
            List<Project> projects=repository.getProjectsByOwnerEmail(email);

            if(projects !=null){
                return projects.stream().map(projectMapper::mapToDto).collect(Collectors.toList());
            }


        }
        catch (Exception e){
            throw new RuntimeException("Error getting projects by owner", e);
        }


        return null;

    }

    @Override
    public ProjectResponseDto getProjectById(Long id) {

        try{
            Project project= repository.findById(id).orElseThrow(null);
            if(project != null){
                return projectMapper.mapToDto(project);
            }

        }
        catch (Exception e){
            throw new RuntimeException("Error getting project", e);
             }
        return null;
    }

    @Override
    public ProjectResponseDto updateProjectById(Long id, Project request) {
        try{
        Project project = repository.findById(id).orElseThrow(null);
        if(project != null){
            project.setName(request.getName());
            project.setDescription(request.getDescription());
            repository.save(project);
            return projectMapper.mapToDto(project);
        }

        }
        catch (Exception e){
            throw new RuntimeException("Error updating project", e);
        }
        return null;
    }

    @Override
    public ProjectResponseDto deleteProjectById(Long id) {
        try {
            Project project = repository.findById(id).orElseThrow(null);
            if (project != null) {
                repository.delete(project);
                return projectMapper.mapToDto(project);
            }


        } catch (Exception e) {
            throw new RuntimeException("Error deleting project", e);
        }

        return new ProjectResponseDto();

    }
}


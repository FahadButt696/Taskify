//package com.taskify.project_management.service;
//
//import com.taskify.project_management.dto.requests.ProjectRequestDto;
//import com.taskify.project_management.dto.responses.ProjectResponseDto;
//import com.taskify.project_management.entity.Project;
//import com.taskify.project_management.exception.ProjectNotFoundException;
//import com.taskify.project_management.mapper.projectMapper;
//import com.taskify.project_management.repository.ProjectRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class ProjectServiceImpl implements ProjectService {
//
//    private final ProjectRepository repository;
////    private final RabbitMQProd publisher;
//    private final RedisTemplate<String, Object> redisTemplate;
//
//    @Override
//    public ProjectResponseDto create(Project request) {
//        Project project = new Project();
//        try{
//            Project saved = repository.save(project);
//
//            return projectMapper.mapToDto(saved);
//            // publish message
////            publisher.sendProjectCreatedMessage(saved);
//        }
//        catch (Exception e){
//            throw new RuntimeException("Error creating project", e);
//
//        }
//
//
//    }
//
//
//    @Override
//    public List<ProjectResponseDto> getProjectsByOwner(Long ownerId) {
//        return repository.findByOwnerId(ownerId)
//                .stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ProjectResponseDto getById(Long id) {
//
//        try{
//            Project project= repository.findById(id).orElseThrow(null);
//            if(project != null){
//                return projectMapper.mapToDto(project);
//            }
//
//        }
//        catch (Exception e){
//            throw new RuntimeException("Error getting project", e);
//        }
//    }
//
//
//
//    @Override
//    public ProjectResponse update(Long id, ProjectRequest request) {
//        Project project = repository.findById(id).orElseThrow(() ->
//                new ProjectNotFoundException("Project not found")
//        );
//
//        project.setName(request.getName());
//        project.setDescription(request.getDescription());
//        project.setTemplate(request.getTemplate());
//        project.setUpdatedAt(LocalDateTime.now());
//        Project updated = repository.save(project);
//
//        // Invalidate cache
//        redisTemplate.delete("project:" + id);
//
//        return mapToResponse(updated);
//    }
//
//    @Override
//    public void delete(Long id) {
//        if (!repository.existsById(id)) {
//            throw new ProjectNotFoundException("Project not found");
//        }
//        repository.deleteById(id);
//        redisTemplate.delete("project:" + id);
//    }
//
//}
//

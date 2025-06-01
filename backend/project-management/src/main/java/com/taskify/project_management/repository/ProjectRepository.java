package com.taskify.project_management.repository;

import com.taskify.project_management.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.createdByUserEmail =: ownerEmail")
    List<Project> getProjectsByOwnerEmail(String ownerEmail);

    @Query("Select p from Project p where p.key =: key")
    Optional<Project> findByKey(String key);
}

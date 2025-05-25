package com.taskify.project_management.entity;

import com.taskify.project_management.enums.ProjectAccess;
import com.taskify.project_management.enums.Template;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name= "project_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Project {
    @Id
    @Column(name = "Project_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Project_Seq")
    @SequenceGenerator(name = "Project_Seq", sequenceName = "Project_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "project_name")
    @NotEmpty(message = "Project should not be empty!!")
    private String name;

    @NotEmpty(message = "Project Description should not be empty!!")
    @Column(name = "project_description")
    private String description;

    @Column(name = "Project_Key")
    private String key;

    @Enumerated(EnumType.STRING)
    private Template template; // KANBAN, SCRUM

    @Enumerated(EnumType.STRING)
    private ProjectAccess access;

    @Column(name = "Lead_By")
    @NotEmpty(message = "project creator should be mention!")
    private String createdByUserEmail;

    @Column(name = "created_at", updatable = false)
    private BigInteger createdAt;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectMember> members = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = BigInteger.valueOf(Instant.now().getEpochSecond());
    }


}

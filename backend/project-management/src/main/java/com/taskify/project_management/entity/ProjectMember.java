package com.taskify.project_management.entity;

import com.taskify.project_management.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectMember {

    @Id
    @Column(name = "Member_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Member_Seq")
    @SequenceGenerator(name = "Member_Seq", sequenceName = "Member_sequence", allocationSize = 1)
    private Long id;

    private String email;

    @Enumerated(EnumType.STRING)
    private ProjectRole role; // MANAGER, DEVELOPER, QA, VIEWER

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}


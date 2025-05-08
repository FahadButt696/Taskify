package com.taskify.project_management.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

@Entity
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

    @ManyToMany
    private Set<User> members;

    @OneToMany(mappedBy = "project")
    private List<Board> boards;
}

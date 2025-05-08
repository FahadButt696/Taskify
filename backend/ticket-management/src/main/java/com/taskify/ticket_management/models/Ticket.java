package com.taskify.ticket_management.models;

import com.sda.project.backend.enums.PriorityLevel;
import com.sda.project.backend.enums.TicketStatus;
import com.sda.project.backend.enums.TicketType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ticket_Seq")
    @SequenceGenerator(name = "Ticket_Seq", sequenceName = "Ticket_sequence", allocationSize = 1)
    private Long id;

    @Column(table = "Issue_title",unique = true)
    @NotEmpty(message = "title should not be empty!!")
    private String title;

    @Column(table = "issue_description")
    @NotEmpty(message = "description should not be empty!!")
    private String description;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "define issue type!!")
    private TicketType issueType;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "must be set priority")
    private PriorityLevel priority;

    @ManyToOne
    private User assignee;

    @ManyToOne
    private Sprint sprint;

    @ManyToOne
    private Board board;

    @ManyToMany
    private List<Label> labels;

    @OneToMany(mappedBy = "issue")
    private List<Comment> comments;

    @OneToMany(mappedBy = "parentIssue")
    private List<SubTask> subtasks;

    @Column(name = "created_at", updatable = false)
    private BigInteger createdAt;

    @Column(name = "last_updated_at")
    private BigInteger updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = BigInteger.valueOf(Instant.now().getEpochSecond());
        updatedAt = BigInteger.valueOf(Instant.now().getEpochSecond());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = BigInteger.valueOf(Instant.now().getEpochSecond());
    }


}


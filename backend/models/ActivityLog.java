package com.sda.project.backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ActivityLog_seq")
    @SequenceGenerator(name = "ActivityLog_seq", sequenceName = "ActivityLog_Sequence", allocationSize = 1)
    private Long id;
    private String action;
    private LocalDateTime timestamp;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket issue;
}


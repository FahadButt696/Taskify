package com.sda.project.backend.models;

import com.sda.project.backend.enums.TicketStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class SubTask {

    @Id
    @Column(name = "Subtask_id",unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Subtask_Seq")
    @SequenceGenerator(name = "Subtask_Seq", sequenceName = "Subtask_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "Subtask_title")
    @NotEmpty(message = "title should not be empty!!")
    private String title;

    @ManyToOne
    private Ticket parentIssue;

    @ManyToOne
    private User assignee;
    @Enumerated(EnumType.STRING)

    private TicketStatus status;

}

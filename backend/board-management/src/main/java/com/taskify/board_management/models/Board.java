package com.taskify.board_management.models;

import com.sda.project.backend.enums.BoardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Board_seq")
    @SequenceGenerator(name = "Board_seq", sequenceName = "Board_Sequence", allocationSize = 1)
    private Long id;

    @Column(name = "board_type")
    @NotEmpty(message = "type must be selected!!")
    @Enumerated(EnumType.STRING)
    private BoardType type;

    private long projectId;

    @OneToMany(mappedBy = "board")
    private List<Ticket> issues;

    @OneToMany(mappedBy = "board")
    private List<Sprint> sprints;
}


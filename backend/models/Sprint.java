package com.sda.project.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sprint_Seq")
    @SequenceGenerator(name = "Sprint_Seq", sequenceName = "Sprint_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "spring_name")
    @NotEmpty(message = "Sprint name should not be empty!!")
    private String name;

    @Column(name= "created_at")
    private BigInteger createdAt;

    @Column(name = "ended_at")
    private BigInteger endedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = BigInteger.valueOf(Instant.now().getEpochSecond());
    }

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "sprint")
    private List<Ticket> issues;
}

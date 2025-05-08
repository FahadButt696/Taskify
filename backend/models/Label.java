package com.sda.project.backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Label {
    @Id
    @Column(name = "Label_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Label_seq")
    @SequenceGenerator(name = "Label_seq", sequenceName = "Label_Sequence", allocationSize = 1)
    private Long id;

    @Column(name = "label_name")
    private String name;

    @ManyToMany(mappedBy = "labels")
    private List<Ticket> issues;
}

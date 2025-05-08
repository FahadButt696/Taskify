package com.taskify.comment_management;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigInteger;
import java.time.Instant;

@Entity
public class Comment {
    @Id
    @Column(name = "Comment_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Comment_seq")
    @SequenceGenerator(name = "Comment_seq", sequenceName = "Comment_Sequence", allocationSize = 1)
    private Long id;

    @Column(name = "comment_content")
    @NotEmpty(message = "content should not be empty!!")
    private String content;

    @Column(name = "created_at")
    private BigInteger createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt= BigInteger.valueOf(Instant.now().getEpochSecond());
    }
    @ManyToOne
    private Ticket issue;

    @ManyToOne
    private User author;
}

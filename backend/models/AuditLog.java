package com.sda.project.backend.models;

import com.sda.project.backend.enums.ActionType;
import jakarta.persistence.*;
import java.math.BigInteger;
import java.time.Instant;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AuditLog_seq")
    @SequenceGenerator(name = "AuditLog_seq", sequenceName = "AuditLog_Sequence", allocationSize = 1)
    @Column(name = "audit_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type")
    private ActionType actionType ;

    @Column(name = "log_description")
    private String Description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "created_by")
    private User creator;

    @Column(name = "created_at")
    private BigInteger createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = BigInteger.valueOf(Instant.now().toEpochMilli());
    }
}

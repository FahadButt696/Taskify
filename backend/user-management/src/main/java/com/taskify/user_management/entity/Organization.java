package com.taskify.user_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Org_Seq")
    @SequenceGenerator(name = "Org_Seq", sequenceName = "Org_sequence", allocationSize = 1)
    private Long id;

    @NotEmpty(message = "OrgName should not be empty!!")
    @Column(name = "Org_Name", unique = true)
    private String name;

    @OneToMany(mappedBy = "organization")
    @JsonBackReference
    private List<User> users;

    @Column(name = "created_at", updatable = false)
    private BigInteger createdAt;


    @PrePersist
    protected void onCreate() {
        createdAt = BigInteger.valueOf(Instant.now().getEpochSecond());
    }

    // metadata like createdDate, orgCode, etc.

    // Getters and Setters
}

package com.taskify.user_management.entity;

import com.taskify.user_management.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Invited_Users")
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Invite_Seq")
    @SequenceGenerator(name = "Invite_Seq", sequenceName = "Invites_sequence", allocationSize = 1)
    private Long id;

    @NotEmpty(message = "organization id should not be empty!")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "organization id should not be empty!")
    @Column(name = "Org_id", unique = true)
    private Long organizationId;
    @NotEmpty(message = "organization id should not be empty!")
    @Column(name = "Org_id", unique = true)
    private String token;
    @NotEmpty(message = "organization id should not be empty!")
    @Column(name = "Org_id", unique = true)
    private StatusEnum status; // PENDING, ACCEPTED, REJECTED
}


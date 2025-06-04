package com.taskify.user_management.entity;

import com.taskify.user_management.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;

@Entity
@Table(name = "Invited_Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Invite_Seq")
    @SequenceGenerator(name = "Invite_Seq", sequenceName = "Invites_sequence", allocationSize = 1)
    private Long id;

    @NotEmpty(message = "email should not be empty!")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "organization id should not be empty!")
    @Column(name = "Org_id", unique = true)
    private Long organizationId;
    @NotEmpty(message = "token should not be empty!")
    @Column(name = "token", unique = true)
    private String token;
    @NotEmpty(message = "status should not be empty!")
    @Column(name = "status", unique = true)
    private StatusEnum status; // PENDING, ACCEPTED, REJECTED
}


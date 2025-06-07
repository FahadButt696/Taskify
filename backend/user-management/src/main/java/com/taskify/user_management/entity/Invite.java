package com.taskify.user_management.entity;

import com.taskify.user_management.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @NotEmpty(message = "token should not be empty!")
    @Column(name = "token", unique = true)
    private String token;
    @NotNull(message = "status should not be Null!")
    @Column(name = "status", unique = true)
    @Enumerated(EnumType.STRING)
    private StatusEnum status; // PENDING, ACCEPTED, REJECTED


}


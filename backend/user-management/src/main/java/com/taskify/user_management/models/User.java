package com.taskify.user_management.models;

import com.taskify.user_management.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Seq")
    @SequenceGenerator(name = "User_Seq", sequenceName = "User_sequence", allocationSize = 1)
    private Long id;


    @NotEmpty(message = "Username should not be empty!!")
    @Column(name = "User_Name", unique = true)
    private String username;

    @NotEmpty(message = "Username should not be empty!!")
    @Column(name = "Email", unique = true)
    private String email;


    @Column(name = "Password")
    @NotEmpty(message = "Password Should not be empty!!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and must contain an uppercase letter, a lowercase letter, a number, and a special character.")
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Set<RoleType> roles;

    @Column(name = "created_at", updatable = false)
    private BigInteger createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = BigInteger.valueOf(Instant.now().getEpochSecond());
    }

}

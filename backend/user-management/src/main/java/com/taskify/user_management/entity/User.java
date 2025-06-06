package com.taskify.user_management.entity;

import com.taskify.user_management.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Seq")
    @SequenceGenerator(name = "User_Seq", sequenceName = "User_sequence", allocationSize = 1)
    private Long id;


    @NotEmpty(message = "Username should not be empty!!")
    @Column(name = "User_Name", unique = true)
    private String name;

    @NotEmpty(message = "email should not be empty!!")
    @Column(name = "Email", unique = true)
    private String email;


    @Column(name = "Password")
    @NotEmpty(message = "Password Should not be empty!!")
    @Size(min = 8, message = "Password must be at least 8 characters long")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
//            message = "Password must be at least 8 characters long and must contain an uppercase letter, a lowercase letter, a number, and a special character.")
    private String pass;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private RoleType role;

    @Column(name = "created_at", updatable = false)
    private BigInteger createdAt;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
//    @Column(name= "Team" )
//    List<User> friends;

    @PrePersist
    protected void onCreate() {
        createdAt = BigInteger.valueOf(Instant.now().getEpochSecond());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public String getPassword() {
        return pass;
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}

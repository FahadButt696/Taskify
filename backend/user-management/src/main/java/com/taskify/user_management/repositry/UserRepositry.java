package com.taskify.user_management.repositry;

import com.taskify.user_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositry extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}

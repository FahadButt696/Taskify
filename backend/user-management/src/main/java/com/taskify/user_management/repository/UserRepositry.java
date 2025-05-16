package com.taskify.user_management.repository;

import com.taskify.user_management.enums.RoleType;
import com.taskify.user_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<User, Long> {

    @Query("SELECT u from User u where u.email= :email")
    User findByEmail(String email);

    @Query("SELECT u.role FROM User u WHERE u.id = :id")
    RoleType findRoleByUserId(long id);
}

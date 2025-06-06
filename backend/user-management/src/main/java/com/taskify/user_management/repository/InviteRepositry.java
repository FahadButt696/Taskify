package com.taskify.user_management.repository;

import com.taskify.user_management.entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InviteRepositry extends JpaRepository<Invite, Long> {

    @Query("Select u from Invite u where u.token =:token")
    Invite findByToken(String token);
}

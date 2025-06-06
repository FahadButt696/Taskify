package com.taskify.user_management.repository;

import com.taskify.user_management.entity.Organization;
import com.taskify.user_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepositry extends JpaRepository<Organization, Integer> {

    @Query("Select u.users from Organization u where u.id = :id")
    List<User> findAllMembersByOrgId(Long id);

    @Query("Select u.users from Organization u")
    List<User> findAllMembers();

    @Query("Select u from Organization u where u.id =:id")
    Organization findById(Long id);

}

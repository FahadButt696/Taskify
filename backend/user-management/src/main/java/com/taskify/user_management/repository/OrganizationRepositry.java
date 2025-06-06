package com.taskify.user_management.repository;

import com.taskify.user_management.entity.Organization;
import com.taskify.user_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepositry extends JpaRepository<Organization, Integer> {
    List<User>  findAllMembersById(Long id);

}

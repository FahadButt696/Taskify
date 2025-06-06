package com.taskify.user_management.service;

import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganizationService {

//    User AddOrganization(String orgName, String token);
    UserResponse getOwnerByOrganizationId(Long id);

    List<UserResponse> findAllUsers();


    OrgRes updateOrgName(Long id, String name);
}

package com.taskify.user_management.service;

import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    User AddOrganization(String orgName, String token);
    OrgRes getOrgByOwnerEmail(String email);



}

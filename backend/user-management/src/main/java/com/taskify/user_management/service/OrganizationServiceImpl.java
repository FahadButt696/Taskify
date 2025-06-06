package com.taskify.user_management.service;

import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.entity.Organization;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.exception.ResourceNotFoundException;
import com.taskify.user_management.mapper.OrgMapper;
import com.taskify.user_management.repository.UserRepositry;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final UserRepositry userRepositry;

    public OrganizationServiceImpl(UserRepositry userRepositry) {
        this.userRepositry = userRepositry;
    }


    @Override
    public OrgRes getOrgByOwnerEmail(String email) {



        catch(ResourceNotFoundException e){
            throw new RuntimeException("Organization not found!");
        }
    }
    @Override
    public User AddOrganization(String orgName, String token) {
        return null;
    }
}

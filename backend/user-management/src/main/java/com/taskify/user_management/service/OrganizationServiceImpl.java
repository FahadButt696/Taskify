package com.taskify.user_management.service;

import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.entity.Organization;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.enums.RoleType;
import com.taskify.user_management.mapper.OrgMapper;
import com.taskify.user_management.mapper.UserMapper;
import com.taskify.user_management.repository.OrganizationRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

   private final OrganizationRepositry organizationRepositry;

    @Override
    public UserResponse getOwnerByOrganizationId(Long id) {

        try {
            List<User> users = organizationRepositry.findAllMembersByOrgId(id);
            for (User user : users) {
                if(user.getRole()==RoleType.ADMIN){
                    return UserMapper.mapToUserDto(user);
                }
                else{
                    return null;
                }
            }
        }
        catch(RuntimeException ignored) {
          throw new RuntimeException("Error Occurred!");

        }
        return null;

    }

    @Override
    public List<UserResponse> findAllUsers() {

       try {
           return organizationRepositry.findAllMembers()
                   .stream().map(UserMapper::mapToUserDto)
                   .toList();
       }
       catch(RuntimeException ignored) {
           throw new RuntimeException("Error Occurred!");
       }

    }

    @Override
    public OrgRes updateOrgName(Long id, String name) {
       Organization organization= organizationRepositry.findById(id);
       if(organization!=null){
           organization.setName(name);
           organizationRepositry.save(organization);
           return OrgMapper.mapToOrgDto(organization);
       }
       else{
           throw new RuntimeException("Organization not found!");
       }

    }
}

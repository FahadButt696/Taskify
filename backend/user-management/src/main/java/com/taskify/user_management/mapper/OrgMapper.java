package com.taskify.user_management.mapper;

import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.entity.Organization;

public class OrgMapper {

    public static OrgRes mapToOrgDto(Organization organization) {
        return new OrgRes(organization.getName());
    }
}

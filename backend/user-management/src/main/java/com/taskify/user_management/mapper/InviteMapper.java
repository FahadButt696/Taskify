package com.taskify.user_management.mapper;

import com.taskify.user_management.dto.responses.InviteResponse;
import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.entity.Invite;
import com.taskify.user_management.entity.Organization;

public class InviteMapper {
    public static InviteResponse mapToInviteDto(Invite invite) {
        return new InviteResponse(invite.getEmail(),invite.getOrganizationId(), invite.getToken());
    }
}
package com.taskify.user_management.service;

import com.taskify.user_management.dto.requests.InviteRequest;
import com.taskify.user_management.entity.Invite;

public interface InviteService {


    public void sendInvite(InviteRequest invite);
    public void acceptInvite(String token,String authHeader);
}

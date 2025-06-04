package com.taskify.user_management.service;

import com.taskify.user_management.dto.requests.InviteRequest;
import com.taskify.user_management.entity.Invite;
import com.taskify.user_management.enums.StatusEnum;
import com.taskify.user_management.messaging.producer.InviteProducer;
import com.taskify.user_management.repository.InviteRepositry;
import com.taskify.user_management.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InviteServiceImpl implements InviteService {

        private final InviteRepositry inviteRepo;
        private final InviteProducer inviteProducer;
        private final JwtUtil jwtUtil; // Your JWT util

        public void sendInvite(InviteRequest request) {
            Invite invite = new Invite();
            invite.setEmail(request.getEmail());
            invite.setOrganizationId(request.getOrganizationId());
            invite.setStatus(StatusEnum.valueOf("PENDING"));
            invite.setToken(UUID.randomUUID().toString());
            inviteRepo.save(invite);

            // Send to RabbitMQ
            inviteProducer.sendToQueue(invite);
        }

        public void acceptInvite(String token, String authHeader) {
//            Invite invite = inviteRepo.findByToken(token)
//                    .orElseThrow(() -> new RuntimeException("Invalid token"));
//
//            invite.setStatus(StatusEnum.valueOf("ACCEPTED"));
//            inviteRepo.save(invite);
//
//            Long userId = jwtUtil.getUserIdFromToken(authHeader);

            // Add to organization table
            // Example: OrganizationUser entity
            // Save userId + invite.getOrganizationId() into org-user table
        }

}

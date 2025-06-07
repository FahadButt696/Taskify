package com.taskify.user_management.service;

import com.taskify.user_management.dto.requests.InviteRequest;
import com.taskify.user_management.entity.Invite;
import com.taskify.user_management.entity.Organization;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.enums.StatusEnum;
import com.taskify.user_management.mapper.InviteMapper;
import com.taskify.user_management.messaging.producer.Producer;
import com.taskify.user_management.repository.InviteRepositry;
import com.taskify.user_management.repository.OrganizationRepositry;
import com.taskify.user_management.repository.UserRepositry;
import com.taskify.user_management.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InviteServiceImpl implements InviteService {

        private final InviteRepositry inviteRepo;
        private final UserRepositry userRepo;
        private final Producer producer;
        private final JwtUtil jwtUtil;// Your JWT util
        private final OrganizationRepositry organizationRepo;

        public void sendInvite(InviteRequest request) {
            Invite invite = new Invite();
            invite.setEmail(request.getEmail());
            invite.setOrganizationId(request.getOrganizationId());
            invite.setStatus(StatusEnum.PENDING);
            invite.setToken(UUID.randomUUID().toString());
            inviteRepo.save(invite);

            // Send to RabbitMQ
            producer.sendToInviteQueue(InviteMapper.mapToInviteDto(invite));
        }

        public void acceptInvite(String token, String authHeader) throws Exception {

            Invite invite = inviteRepo.findByToken(token);

            if(invite==null){
                throw new Exception("Invite Not Found");
            }
            User user= userRepo.findByEmail(invite.getEmail());

            if(user==null){
                throw new Exception("User Not Found in Taskify!");
            }

            invite.setStatus(StatusEnum.APPROVED);
            inviteRepo.save(invite);

            Organization organization = organizationRepo.findById(invite.getOrganizationId());
            if(organization==null){
                throw new Exception("Organization Not Found");
            }
            List<User> users= new ArrayList<User>();
            users.add(user);
            organization.setUsers(users);
            organizationRepo.save(organization);

        }

}

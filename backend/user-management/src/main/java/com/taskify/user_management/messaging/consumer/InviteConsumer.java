package com.taskify.user_management.messaging.consumer;

import com.taskify.user_management.entity.Invite;
import com.taskify.user_management.messaging.config.RabbitMQConfig;
import com.taskify.user_management.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.taskify.user_management.messaging.config.RabbitMQConfig.*;

@Component
@RequiredArgsConstructor
public class InviteConsumer {

        private final MailService mailService;

        @RabbitListener()
        public void handleInvite(Invite invite) {
            String subject = "You're invited to join an organization!";
            String acceptLink = "http://localhost:8080/api/invite/accept/" + invite.getToken();
            String body = "Click here to accept the invitation: " + acceptLink;

            mailService.sendMail(invite.getEmail(), subject, body);
        }
    }


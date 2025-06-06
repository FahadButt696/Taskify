package com.taskify.user_management.messaging.consumer;

import com.taskify.user_management.entity.Invite;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {
        private final MailService mailService;

        @RabbitListener(queues = "INVITE_QUEUE")
        public void handleInvite(Invite invite) {
            String subject = "You're invited to join an organization!";
            String acceptLink = "http://localhost:8081/api/invite/accept/" + invite.getToken();
            String body = "Click here to accept the invitation: " + acceptLink;

            mailService.sendMail(invite.getEmail(), subject, body);
        }


        @RabbitListener(queues = "REGISTER_QUEUE")
        public void handleRegistration(User user) {
            String subject = "Congratulations for successfull registrtion!";
            //put Login page route here
            String acceptLink = "http://localhost:8081/api/invite/accept/";
            String body= "Hello! " +user.getName().toUpperCase()+ "\nYou" +
                    "are successfully registered to Taskify.We hope that you enjoy our services\n"+
                    "Thank you!\n"+
                    "Click here to login: "+ acceptLink;
            mailService.sendMail(user.getEmail(), subject, body);
        }
    }


package com.taskify.user_management.messaging.producer;

import com.taskify.user_management.dto.responses.InviteResponse;
import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.entity.Invite;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.messaging.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {
        private final RabbitTemplate rabbitTemplate;


        public void sendToInviteQueue(InviteResponse invite) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.exchange,RabbitMQConfig.InviteKey, invite);
        }

        public void sendToRegisterQueue(UserResponse user) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.exchange,RabbitMQConfig.RegisterKey, user);
        }
}

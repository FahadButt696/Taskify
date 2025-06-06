package com.taskify.user_management.messaging.producer;

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

        public void sendToInviteQueue(Invite invite) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.INVITE_QUEUE, invite);
        }

        public void sendToRegisterQueue(User user) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.REGISTER_QUEUE, user);
        }
}

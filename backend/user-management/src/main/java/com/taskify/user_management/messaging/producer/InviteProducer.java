package com.taskify.user_management.messaging.producer;

import com.taskify.user_management.entity.Invite;
import com.taskify.user_management.messaging.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InviteProducer {
        private final RabbitTemplate rabbitTemplate;

        public void sendToQueue(Invite invite) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.INVITE_QUEUE, invite);
        }

}

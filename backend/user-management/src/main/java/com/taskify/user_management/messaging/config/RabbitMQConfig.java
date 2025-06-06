package com.taskify.user_management.messaging.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static org.springframework.amqp.core.ExchangeBuilder.topicExchange;

@Configuration
public class RabbitMQConfig {
//            @Value("${queue.notification_queue}")
//            public String notificationQueue;
//
//            @Value("${queue.dormancy_queue}")
//            public String dormancyQueue;
//
//            @Value("${queue.Invite.queue}")
            public static String INVITE_QUEUE= "inviteQueue";

            public static String REGISTER_QUEUE= "registerQueue";


//            @Value("${exchange.name}")
            public String exchange= "exchange";

//            @Value("${routing.Invitation_key}")
            public String InviteKey = "inviteKey";
            public String RegisterKey= "registerKey";
//            @Value("${routing.dormancy_key}")
//            public String dormancyKey;
//
//            @Value("${routing.document_attach_key}")
//            public String documentAttachKey;




//            @Bean
//            public Queue newNotificationQueue() {
//                return new Queue(notificationQueue);
//            }

//            @Bean
//            public org.springframework.amqp.core.Queue documentQueue() {
//              return new org.springframework.amqp.core.Queue(dormancyQueue);
//            }

            @Bean
            public Queue newInviteQueue() {
                return new Queue(INVITE_QUEUE);
            }

            @Bean
            public Queue newRegisterQueue() {return new Queue(REGISTER_QUEUE);}
            @Bean
            public TopicExchange topicExchange() {
                return new TopicExchange(exchange);
            }
//
//            @Bean
//            public Binding binding() {
//                return BindingBuilder.bind(newNotificationQueue()).to(topicExchange()).with(notificationKey);
//            }
//            @Bean
//            public Binding dormancyBinding() {
//                return BindingBuilder.bind(newInviteQueue()).to(topicExchange()).with(InviteKey);
//            }
//            @Bean
//            public Binding documentBinding() {
//                return BindingBuilder.bind(documentQueue()).to(topicExchange()).with(documentAttachKey);
//            }

            @Bean
            public MessageConverter messageConverter() {
                return new Jackson2JsonMessageConverter();
            }

            @Bean
            public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
                SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
                factory.setConnectionFactory(connectionFactory);
                factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
                factory.setMessageConverter(messageConverter);
                return factory;
            }

            @Bean
            public AmqpTemplate template(ConnectionFactory connectionFactory) {
                RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
                rabbitTemplate.setMessageConverter(messageConverter());
                return rabbitTemplate;
            }

        }














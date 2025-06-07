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
            public static String INVITE_QUEUE= "inviteQueue";

            public static String REGISTER_QUEUE= "registerQueue";

            public static String exchange= "exchange";

            public static String InviteKey = "inviteKey";
            public static String RegisterKey= "registerKey";

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
            @Bean
            public Binding Registerbinding() {
                return BindingBuilder.bind(newRegisterQueue()).to(topicExchange()).with(RegisterKey);
            }
            @Bean
            public Binding InviteBinding() {
                return BindingBuilder.bind(newInviteQueue()).to(topicExchange()).with(InviteKey);
            }
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














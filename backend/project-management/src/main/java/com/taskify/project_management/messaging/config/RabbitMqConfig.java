//package com.taskify.project_management.messaging.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//public class RabbitMqConfig {
//
//    @Configuration
//    public class RabbitMQConfig {
//
//        @Value("${queue.notification_queue}")
//        public String notificationQueue;
//
//        @Value("${queue.dormancy_queue}")
//        public String dormancyQueue;
//
//        @Value("${queue.document_attach_queue}")
//        public String documentAttachQueue;
//
//        @Value("${exchange.name}")
//        public String exchange;
//
//        @Value("${routing.notification_key}")
//        public String notificationKey;
//        @Value("${routing.dormancy_key}")
//        public String dormancyKey;
//
//        @Value("${routing.document_attach_key}")
//        public String documentAttachKey;
//
//
//
//        @Bean
//        public Queue newNotificationQueue() {
//            return new Queue(notificationQueue);
//        }
//
//        @Bean
//        public Queue documentQueue() {
//            return new Queue(documentAttachQueue);
//        }
//
//        @Bean
//        public Queue newDormancyQueue() {
//            return new Queue(dormancyQueue);
//        }
//
//        @Bean
//        public TopicExchange topicExchange() {
//            return new TopicExchange(exchange);
//        }
//
//        @Bean
//        public Binding binding() {
//            return BindingBuilder.bind(newNotificationQueue()).to(topicExchange()).with(notificationKey);
//        }
//        @Bean
//        public Binding dormancyBinding() {
//            return BindingBuilder.bind(newDormancyQueue()).to(topicExchange()).with(dormancyKey);
//        }
//        @Bean
//        public Binding documentBinding() {
//            return BindingBuilder.bind(documentQueue()).to(topicExchange()).with(documentAttachKey);
//        }
//
//        @Bean
//        public MessageConverter messageConverter() {
//            return new Jackson2JsonMessageConverter();
//        }
//
//        @Bean
//        public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
//            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//            factory.setConnectionFactory(connectionFactory);
//            factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//            factory.setMessageConverter(messageConverter);
//            return factory;
//        }
//
//        @Bean
//        public AmqpTemplate template(ConnectionFactory connectionFactory) {
//            RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//            rabbitTemplate.setMessageConverter(messageConverter());
//            return rabbitTemplate;
//        }
//
//    }
//
//
//
//
//
//
//
//
//
//
//}

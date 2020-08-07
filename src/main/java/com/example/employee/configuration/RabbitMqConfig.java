package com.example.employee.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;


public class RabbitMqConfig extends SpringBootServletInitializer implements RabbitListenerConfigurer {
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }

//    @Autowired
//    private ApplicationConfigReader applicationConfig;
//
//    public ApplicationConfigReader getApplicationConfig() {
//        return applicationConfig;
//    }
//
//    public void setApplicationConfig(ApplicationConfigReader applicationConfig) {
//        this.applicationConfig = applicationConfig;
//    }
//
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(RabbitMqConfig.class);
//    }
//
//    @Bean
//    public ApplicationConfigReader applicationConfig() {
//        return new ApplicationConfigReader();
//    }
//
//    @Bean
//    public TopicExchange getEmployeeExchange() {
//        return new TopicExchange(getApplicationConfig().getEmployeeExchange());
//    }
//
//    @Bean
//    public Queue getEmployeeQueue() {
//        return new Queue(getApplicationConfig().getEmployeeQueue());
//    }
//
//    @Bean
//    public Binding declareBindingApp1() {
//        return BindingBuilder.bind(getEmployeeQueue()).to(getEmployeeExchange())
//                .with(getApplicationConfig().getEmployeeRoutingKey());
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//        return rabbitTemplate;
//    }
//    @Bean
//    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//    @Bean
//    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
//        return new MappingJackson2MessageConverter();
//    }
//    @Bean
//    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
//        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
//        factory.setMessageConverter(consumerJackson2MessageConverter());
//        return factory;
//    }
//    @Override
//    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
//        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
//    }

}

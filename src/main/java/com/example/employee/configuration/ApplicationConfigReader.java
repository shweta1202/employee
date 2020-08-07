package com.example.employee.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfigReader {

    @Value("${employee.exchange.name}")
    private String employeeExchange;
    @Value("${employee.queue.name}")
    private String employeeQueue;
    @Value("${employee.routing.key}")
    private String employeeRoutingKey;

    public String getEmployeeExchange() {
        return employeeExchange;
    }

    public void setEmployeeExchange(String employeeExchange) {
        this.employeeExchange = employeeExchange;
    }

    public String getEmployeeQueue() {
        return employeeQueue;
    }

    public void setEmployeeQueue(String employeeQueue) {
        this.employeeQueue = employeeQueue;
    }

    public String getEmployeeRoutingKey() {
        return employeeRoutingKey;
    }

    public void setEmployeeRoutingKey(String employeeRoutingKey) {
        this.employeeRoutingKey = employeeRoutingKey;
    }


    @Bean
    Queue queue() {
        return new Queue(employeeQueue, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(employeeExchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(employeeRoutingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

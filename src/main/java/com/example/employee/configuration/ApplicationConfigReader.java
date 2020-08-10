package com.example.employee.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Application config reader.
 */
@Configuration
public class ApplicationConfigReader {

    @Value("${employee.exchange.name}")
    private String employeeExchange;

    @Value("${employee.queue.name}")
    private String employeeQueue;

    @Value("${employee.routing.key}")
    private String employeeRoutingKey;

    /**
     * Queue queue.
     *
     * @return the queue
     */
    @Bean
    Queue queue() {
        return new Queue(employeeQueue, false);
    }

    /**
     * Exchange direct exchange.
     *
     * @return the direct exchange
     */
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(employeeExchange);
    }

    /**
     * Binding binding.
     *
     * @param queue    the queue
     * @param exchange the exchange
     * @return the binding
     */
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(employeeRoutingKey);
    }

    /**
     * Json message converter message converter.
     *
     * @return the message converter
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

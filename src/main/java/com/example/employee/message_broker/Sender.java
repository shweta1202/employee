package com.example.employee.message_broker;

import com.example.employee.dto.EmployeeDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The type Sender.
 */
@Component
public class Sender {
    final private AmqpTemplate rabbitTemplate;

    @Value("${employee.exchange.name}")
    private String exchange;

    @Value("${employee.routing.key}")
    private String routingKey;

    /**
     * Instantiates a new Sender.
     *
     * @param rabbitTemplate the rabbit template
     */
    public Sender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Send.
     *
     * @param employeeDto the employee dto
     */
    public void send(EmployeeDto employeeDto) {
        rabbitTemplate.convertAndSend(exchange, routingKey, employeeDto);
    }
}

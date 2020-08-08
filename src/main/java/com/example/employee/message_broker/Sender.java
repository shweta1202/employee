package com.example.employee.message_broker;

import com.example.employee.dto.EmployeeDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    final private AmqpTemplate rabbitTemplate;

    @Value("${employee.exchange.name}")
    private String exchange;

    @Value("${employee.routing.key}")
    private String routingKey;

    public Sender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(EmployeeDto employeeDto) {
        rabbitTemplate.convertAndSend(exchange, routingKey, employeeDto);
    }
}

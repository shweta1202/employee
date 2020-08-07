package com.example.employee.mesaage_broker;

import com.example.employee.dto.EmployeeDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${employee.exchange.name}")
    private String exchange;

    @Value("${employee.queue.name}")
    private String routingKey;

    public void send(EmployeeDto employeeDto) {
        rabbitTemplate.convertAndSend(exchange, routingKey, employeeDto);
        System.out.println("Send msg = " + employeeDto);

    }

//    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
//
//    public void sendMessage(RabbitTemplate rabbitTemplate, String exchange, String routingKey, EmployeeDto employeeDto) {
//
//        LOGGER.info("Sending message to the queue");
//        rabbitTemplate.convertAndSend(exchange, routingKey, employeeDto);
//        LOGGER.info("Message has been sent");
//    }
}

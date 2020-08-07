package com.example.employee.controller;

import com.example.employee.configuration.ApplicationConfigReader;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.mesaage_broker.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/queue")
public class RabbitMqController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqController.class);

    @Autowired
    private Sender rabbitMQSender;

    @PostMapping(value = "/add")
    public String producer(@RequestBody EmployeeDto employeeDto) {

        rabbitMQSender.send(employeeDto);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}

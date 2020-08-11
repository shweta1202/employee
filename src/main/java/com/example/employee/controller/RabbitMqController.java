package com.example.employee.controller;

import com.example.employee.constant.Constants;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.message_broker.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Rabbit mq controller.
 */
@RestController
@RequestMapping(path = "/queue")
public class RabbitMqController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqController.class);

    @Autowired
    private Sender rabbitMQSender;

    /**
     * Producer string.
     *
     * @param employeeDto the employee dto
     * @return the string
     */
    @PostMapping("/add")
    public String producer(@RequestBody EmployeeDto employeeDto) {
        rabbitMQSender.send(employeeDto);
        return Constants.EMPLOYEE_UPDATE_PUBLISHED;
    }
}

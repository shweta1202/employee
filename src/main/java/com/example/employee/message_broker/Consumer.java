package com.example.employee.message_broker;

import com.example.employee.constant.Constants;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.exception.InternalServerErrorException;
import com.example.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    final private EmployeeService employeeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    public Consumer(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RabbitListener(queues = "${employee.queue.name}")
    public void receivedMessage(final EmployeeDto employee) throws InternalServerErrorException {
        employeeService.addOrUpdateEmployee(employee);
        LOGGER.info(Constants.EMPLOYEE_DATA_UPDATED);
    }
}

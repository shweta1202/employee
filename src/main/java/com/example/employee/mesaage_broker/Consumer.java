package com.example.employee.mesaage_broker;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.exception.InternalServerErrorException;
import com.example.employee.service.EmployeeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    final private EmployeeService employeeService;

    public Consumer(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RabbitListener(queues = "${employee.queue.name}")
    public void receivedMessage(final EmployeeDto employee) throws InternalServerErrorException {
        employeeService.addOrUpdateEmployee(employee);
    }
}

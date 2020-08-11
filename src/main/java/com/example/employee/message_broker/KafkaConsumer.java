package com.example.employee.message_broker;

import com.example.employee.constant.Constants;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.exception.InternalServerErrorException;
import com.example.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private EmployeeService employeeService;

    @KafkaListener(topics = "Employee")
    public void consume(EmployeeDto employeeDto) throws InternalServerErrorException {
        employeeService.addOrUpdateEmployee(employeeDto);
        LOGGER.info(Constants.EMPLOYEE_DATA_UPDATED);
    }
}

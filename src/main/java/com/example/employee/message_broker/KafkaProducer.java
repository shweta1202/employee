package com.example.employee.message_broker;

import com.example.employee.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "Employee";

    @Autowired
    private KafkaTemplate<String, EmployeeDto> kafkaTemplate;

    public void sendMessage(EmployeeDto employeeDto) {
        LOGGER.info("Producing Message");
        kafkaTemplate.send(TOPIC, employeeDto);
        LOGGER.info("Message published");
    }
}

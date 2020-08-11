package com.example.employee.controller;

import com.example.employee.constant.Constants;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.message_broker.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PutMapping("/publish")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody EmployeeDto employeeDto) {
        this.kafkaProducer.sendMessage(employeeDto);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.EMPLOYEE_DATA_UPDATED);
    }
}

package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RabitMqListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabitMqListener.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info("Consuming");
    }


//    @Autowired
//    ApplicationConfigReader applicationConfigReader;
//
//    @RabbitListener(queues = "${employee.queue.name}")
//    public void receiveMessageForApp1(final EmployeeDto data) {
//        LOGGER.info("Received message: {} from app1 queue.", data);
//        try {
//            LOGGER.info("Making REST call to the API");
//            //TODO: Code to make REST call
//            LOGGER.info("<< Exiting receiveMessageForApp1() after API call.");
//        } catch(HttpClientErrorException ex) {
//            if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
//                LOGGER.info("Delay...");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) { }
//                LOGGER.info("Throwing exception so that message will be requed in the queue.");
//                // Note: Typically Application specific exception should be thrown below
//                throw new RuntimeException();
//            } else {
//                throw new AmqpRejectAndDontRequeueException(ex);
//            }
//        } catch(Exception e) {
//            LOGGER.error("Internal server error occurred in API call. Bypassing message requeue {}", e);
//            throw new AmqpRejectAndDontRequeueException(e);
//        }
//    }
}

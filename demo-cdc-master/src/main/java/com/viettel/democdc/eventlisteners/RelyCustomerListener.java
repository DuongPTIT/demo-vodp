package com.viettel.democdc.eventlisteners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viettel.democdc.Domain.RelyMessage;
import com.viettel.democdc.Repositories.RelyMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RelyCustomerListener {
    @Autowired
    private RelyMessageRepository relyMessageRepository;

    @KafkaListener(topics = "rely-customer-topic", groupId = "group-customer",
            containerFactory = "relyKafkaListenerFactory")
    public void messageListener(String message) throws JsonProcessingException {
        System.out.println("Nhan duoc message: " + message);
        relyMessageRepository.deleteAll();
        relyMessageRepository.save(new RelyMessage(message));

    }
}

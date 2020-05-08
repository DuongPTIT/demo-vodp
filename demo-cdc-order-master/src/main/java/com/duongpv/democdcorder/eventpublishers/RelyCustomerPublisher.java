package com.duongpv.democdcorder.eventpublishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RelyCustomerPublisher {
    private final static String TOPIC = "rely-customer-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String msg) {
        kafkaTemplate.send(TOPIC, msg);
    }
}

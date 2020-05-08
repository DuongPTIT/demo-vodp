package com.duongpv.democdcorder.eventlisteners;

import com.duongpv.democdcorder.domain.events.CommonEvent;
import com.duongpv.democdcorder.domain.events.CustomerCreatedEvent;
import com.duongpv.democdcorder.eventpublishers.RelyCustomerPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@Service
public class CustomerEventListener {
    Logger logger = LogManager.getLogger();

    @Autowired
    private RelyCustomerPublisher relyCustomerPublisher;


    @KafkaListener(topics = "outbox.event.Customer", groupId = "group-order",
            containerFactory = "customerKafkaListenerFactory")
    public void messageListener(String message) throws JsonProcessingException, JSONException {

        System.out.println("#################################################");
        System.out.println("Da consume message: " + message);
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(message).get("payload");
        JSONObject jsonObject = new JSONObject(message).getJSONObject("payload");
        CommonEvent event = new CommonEvent();
        event.setAggId(jsonObject.getInt("id"));
        event.setEventType(jsonObject.getString("eventType"));
        event.setPayload( new JSONObject(jsonObject.getString("payload")));
        logger.info("Aggregate ID: " + event.getAggId());
        logger.info("Event Type: " + event.getEventType());
        logger.info("Payload:" + event.getPayload());

        String msgContent = "OrderService received event " + event.getEventType() + event.getPayload().getString("name");
        System.out.println("publish message:" + msgContent);
        relyCustomerPublisher.publish(msgContent);

    }
}

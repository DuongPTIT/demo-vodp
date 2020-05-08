package com.viettel.democdc.Domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "outbox")
public class Outbox {
    @Id
    private String id;

    @Column(name = "aggregatetype")
    private String aggregateType;

    @Column(name = "aggregateid")
    private String aggregateId;

    @Column(name = "type")
    private String type;

    @Column(name = "payload")
    private String payload;

    public Outbox() {
    }

    public Outbox(String id, String aggregateType, String aggregateId, String type, String payload) {
        this.id = id;
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.type = type;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
    private static ObjectMapper mapper = new ObjectMapper();

    public static Outbox createOutboxWithCustomer(Customer customer, Operation op){



        ObjectNode json = mapper.createObjectNode()
                .put("id", customer.getId())
                .put("name", customer.getName())
                .put("creditLimit", customer.getCreditLimit())
                .put("company", customer.getCompany());

        try {
            Outbox outbox = new Outbox();
            outbox.setId(UUID.randomUUID().toString());
            outbox.setType(op.toString());
            outbox.setAggregateType("Customer");
            outbox.setAggregateId(customer.getId().toString());
            outbox.setPayload(mapper.writeValueAsString(json));
            System.out.println("Tao outbox:" + outbox);
            return outbox;
        } catch (Exception ex){
            System.out.println("Loi outbox");
            ex.printStackTrace();
        }

        return null;

    }


}

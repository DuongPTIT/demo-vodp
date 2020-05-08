package com.duongpv.democdcorder.domain.events;

import org.json.JSONObject;

import java.io.Serializable;

public class CommonEvent implements Serializable {
    private int aggId;
    private String eventType;
    private JSONObject payload;

    public CommonEvent() {
    }

    public CommonEvent(int aggId, String eventType, JSONObject payload) {
        this.aggId = aggId;
        this.eventType = eventType;
        this.payload = payload;
    }

    public int getAggId() {
        return aggId;
    }

    public void setAggId(int aggId) {
        this.aggId = aggId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public JSONObject getPayload() {
        return payload;
    }

    public void setPayload(JSONObject payload) {
        this.payload = payload;
    }
}

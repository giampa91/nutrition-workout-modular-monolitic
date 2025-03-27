package com.nutrition.workout.workoutexecutionservice.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class MessageDto {

    @JsonProperty("eventName")
    private String eventName;      // Event name, e.g., "USER_CREATED"
    @JsonProperty("id")
    private Long id;               // Unique identifier for the event
    @JsonProperty("timestamp")
    private String timestamp;      // Timestamp of when the event occurred
    @JsonProperty("header")
    private Map<String, String> header; // Header for additional metadata (optional)
    @JsonProperty("data")
    private Map<String, Object> data;   // Map to store the actual data (JSON)

    public MessageDto() {}

    public MessageDto(String eventName, Long id, String timestamp, Map<String, Object> data) {
        this.eventName = eventName;
        this.id = id;
        this.data = data;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
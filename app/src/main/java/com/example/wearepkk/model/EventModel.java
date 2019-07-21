package com.example.wearepkk.model;

import com.google.type.Date;

public class EventModel {
    private String title_event;
    private String location;
    private String timestamp;


    public EventModel(String title_Event, String location, String timestamp) {
        this.title_event = title_Event;
        this.location = location;
        this.timestamp = timestamp;
    }

    public EventModel() {

    }

    public String getTitle_Event() {
        return title_event;
    }

    public void setTitle_Event(String title_Event) {
        this.title_event = title_Event;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

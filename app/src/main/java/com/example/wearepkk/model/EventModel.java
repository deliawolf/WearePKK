package com.example.wearepkk.model;

import com.google.type.Date;

public class EventModel {
    private String title_event;
    private String location;
    private String timestamp;
    private String description_event;
    private String dress_code;


    public EventModel(String title_event, String location, String timestamp, String description_event, String dress_code) {
        this.title_event = title_event;
        this.location = location;
        this.timestamp = timestamp;
        this.description_event = description_event;
        this.dress_code = dress_code;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public String getDress_code() {
        return dress_code;
    }

    public void setDress_code(String dress_code) {
        this.dress_code = dress_code;
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

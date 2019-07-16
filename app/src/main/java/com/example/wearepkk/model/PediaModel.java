package com.example.wearepkk.model;

public class PediaModel {
    private String title;
    private String description;

    public PediaModel() {
        //empty
    }

    public PediaModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

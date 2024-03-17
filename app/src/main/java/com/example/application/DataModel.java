package com.example.application;

public class DataModel {
    private String text;
    private String imageUrl;

    public DataModel(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

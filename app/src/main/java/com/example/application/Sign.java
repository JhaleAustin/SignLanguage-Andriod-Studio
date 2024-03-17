package com.example.application;
// Sign.java
public class Sign {
    private String signName;
    private String imageUrl;

    public Sign(String signName, String imageUrl) {
        this.signName = signName;
        this.imageUrl = imageUrl;
    }

    public String getSignName() {
        return signName;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}


package com.example.application;

public class item {

    String letter;
    int image;

    public item(String letter, int image) {
        this.letter = letter;
        this.image = image;
    }

    public String getLetter() {
        return letter;
    }

    public int getImg() {
        return image;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setImg(int image) {
        this.image = image;
    }

}

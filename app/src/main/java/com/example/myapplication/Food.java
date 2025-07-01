package com.example.myapplication;
public class Food {
    private String name;
    private int imageResId;

    public Food(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}

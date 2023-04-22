package com.example.myapplication110.data.models;


public class Drinks2 {

    int image;
    String name;
    String volume;

    public Drinks2(String name, String volume, int image) {
        this.image = image;
        this.name = name;
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

}


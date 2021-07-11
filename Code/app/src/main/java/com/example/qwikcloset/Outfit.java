package com.example.qwikcloset;

public class Outfit {
    ClothingItem top;
    ClothingItem bottom;
    ClothingItem shoes;
    ClothingItem accessory1;
    ClothingItem accessory2;
    ClothingItem accessory3;
    String mood;
    String temperature;
    String precipitation;
    String task;
    String color;

    public Outfit(){
        top = null;
        bottom = null;
        shoes = null;
        accessory1 = null;
        accessory2 = null;
        accessory3 = null;
        mood = null;
        temperature = null;
        precipitation = null;
        task = null;
        color = null;
    }

    //TODO: Make a method to store the data into the database
}

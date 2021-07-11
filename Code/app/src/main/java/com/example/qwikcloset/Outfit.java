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
    Integer rating;


    public Outfit(ClothingItem top, ClothingItem bottom, ClothingItem shoes, ClothingItem acc1, ClothingItem acc2, ClothingItem acc3, String mood, String temperature, String precipitation, String task, String color, Integer rating){
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        accessory1 = acc1;
        accessory2 = acc2;
        accessory3 = acc3;
        this.mood = mood;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.task = task;
        this.color = color;
        this.rating = rating;

    }

    public Outfit(){
        this.top = null;
        this.bottom = null;
        this.shoes = null;
        accessory1 = null;
        accessory2 = null;
        accessory3 = null;
        this.mood = null;
        this.temperature = null;
        this.precipitation = null;
        this.task = null;
        this.color = null;
        this.rating = null;
    }

    //TODO: Make a method to store the data into the database
}

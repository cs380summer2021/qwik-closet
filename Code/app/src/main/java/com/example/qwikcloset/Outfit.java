package com.example.qwikcloset;

import java.util.ArrayList;

public class Outfit {
    String id;
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
    ArrayList<ClothingItem> clothing;


    public Outfit(String id, ClothingItem top, ClothingItem bottom, ClothingItem shoes, ClothingItem acc1, ClothingItem acc2, ClothingItem acc3, String mood, String temperature, String precipitation, String task, String color, Integer rating){
        this.id = id;
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

        clothing = new ArrayList<>();
        clothing.add(top);
        clothing.add(bottom);
        clothing.add(shoes);
        clothing.add(accessory1);
        clothing.add(accessory2);
        clothing.add(accessory3);
    }

    public Outfit(){
        this.id = null;
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

}

package com.example.qwikcloset;

import android.graphics.drawable.Drawable;

public class ClothingItem {
    int id;
    String category;
    String subCategory;
    String specificCategory;
    String mood;
    String weather;
    String task;
    String color;
    Drawable picture;

    public ClothingItem(int id, String category, String subCategory, String specificCategory, String mood, String weather, String task, String color, Drawable picture){
        this.id = id;
        this.category = category;
        this.subCategory = subCategory;
        this.specificCategory = specificCategory;
        this.mood = mood;
        this.weather = weather;
        this.task = task;
        this.color = color;
        this.picture = picture;
    }
}

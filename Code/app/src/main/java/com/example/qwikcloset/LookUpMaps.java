package com.example.qwikcloset;

import android.util.Log;

import java.util.HashMap;

public class LookUpMaps{
    static String[] shirts = {"Crop Top", "T-Shirt", "Tank Top", "Long-Sleeve Shirt", "Polo", "Dress Shirt"};
    static String[] dresses = {"Long Dress", "Medium Dress", "Short Dress"};
    static String[][] tops = {shirts, dresses};
    static String[] pants = {"Jeans", "Slacks", "Leggings", "Cargo pants"};
    static String[] shorts = {"Sport Shorts", "Booty Shorts", "Jean Shorts"};
    static String[] skirts = {"Tight", "Straight", "Loose Pleat"};
    static String[][] bottoms = {pants, shorts, skirts};
    static String[][] shoes = {{"Tennis Shoes", "Boots", "Dress Shoes", "Heels", "Wedges", "Open-toed Shoes"}};
    static String[][] accessories = {{"Jacket", "Jewelry", "Makeup"}};
    static String[][][] clothing = {tops, bottoms, shoes, accessories};

    public static String toString(int[] array){
        String output = "[";
        for(int i = 0; i < array.length; ++i){
            if(i > 0){
                output += ", ";
            }
            output += array[i];
        }
        output += "]";
        return output;
    }

    static String map(int generalCategory, int subCategory, int clothingType){
        try{
            return clothing[generalCategory][subCategory][clothingType];
        }
        catch (Exception e){
            return "ERROR";
        }
    }

    static int[] map(String clothingName) {
        HashMap<String, Integer[]> reverseMap = new HashMap<String, Integer[]>();
        int[] temp = {0};
        for (int i = 0; i < clothing.length; ++i) {
            for (int j = 0; j < clothing[i].length; ++j) {
                for (int k = 0; k < clothing[i][j].length; ++k) {
                    temp = new int[]{i, j, k};
                    reverseMap.put(clothing[i][j][k], new Integer[]{(i + 1), (j + 1), (k + 1)});
                }
            }
        }
        Integer[] unfilteredOutput = reverseMap.get(clothingName);
        if(unfilteredOutput == null){
            return null;
        }
        int[] output = new int[]{unfilteredOutput[0].intValue(), unfilteredOutput[1].intValue(), unfilteredOutput[2].intValue()};
        return output;
    }
}

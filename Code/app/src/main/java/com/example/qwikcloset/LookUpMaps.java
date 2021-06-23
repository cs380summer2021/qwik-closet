package com.example.qwikcloset;

import java.util.HashMap;
public class LookUpMaps {
    static String[] shirts = {"Crop top", "T-shirt", "Tank top", "Long-sleeve shirt", "Polo", "Dress Shirt"};
    static String[] dresses = {"Long Dress", "Medium Dress", "Short Dress"};
    static String[][] tops = {shirts, dresses};
    static String[] pants = {"Jeans", "Slacks", "Leggings", "Cargo pants"};
    static String[] shorts = {"Sport", "Booty", "Jean"};
    static String[] skirts = {"Tight", "Straight", "Loose pleat"};
    static String[][] bottoms = {pants, shorts, skirts};
    static String[][] shoes = {{"Tennis shoes", "Boots", "Dress shoes", "Heels", "Wedges", "Open-toed shoes"}};
    static String[][] accessories = {{"Jacket", "Jewelry", "Makeup"}};
    static String[][][] clothing = {tops, bottoms, shoes, accessories};

    static String clothingName(int generalCategory, int subCategory, int clothingType){
        return clothing[generalCategory][subCategory][clothingType];
    }

    static int[] reverseMap(String clothingName){
        HashMap<String, Integer[]> reverseMap = new HashMap<String, Integer[]>();
        int[] temp = {0};
        for(int i = 0; i < clothing.length; ++i){
            for(int j = 0; j < clothing[i].length; ++j){
                for(int k = 0; k < clothing[i][j].length; ++k){
                    temp = new int[]{i, j, k};
                    reverseMap.put(clothing[i][j][k], new Integer[]{i, j, k});
                }
            }
        }
        Integer[] unfilteredOutput = reverseMap.get(clothingName);
        int[] output = new int[]{unfilteredOutput[0].intValue(), unfilteredOutput[1].intValue(), unfilteredOutput[2].intValue()};
        return output;
    }

    public static void main(String[]args){
        int[] temp = reverseMap("Crop top");
        System.out.println(reverseMap("Crop top"));
    }

}

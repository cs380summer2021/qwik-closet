package com.example.qwikcloset;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Clothing.db";
    public static final String TABLE_1 = "Tops_table";
    public static final String COL_1_TABLE_1 = "Top_ID";
    public static final String COL_2_TABLE_1 = "Top_Name";
    public static final String COL_3_TABLE_1 = "Crop Top";
    public static final String COL_4_TABLE_1 = "T-Shirt";
    public static final String COL_5_TABLE_1 = "Tank Top";
    public static final String COL_6_TABLE_1 = "Long Sleeve / Flannel";
    public static final String COL_7_TABLE_1 = "Collared Shirt";
    public static final String COL_8_TABLE_1 = "Dress Shirt / Blouse";
    public static final String COL_9_TABLE_1 = "Long Dress";
    public static final String COL_10_TABLE_1 = "Medium Dress";
    public static final String COL_11_TABLE_1 = "Short Dress";
    public static final String COL_12_TABLE_1 = "Shirt";
    public static final String COL_13_TABLE_1 = "Dress";
    public static final String COL_14_TABLE_1 = "Bottoms Required?";
    public static final String TABLE_2 = "Bottoms_table";
    public static final String TABLE_3 = "Shoes_table";
    public static final String TABLE_4 = "Accessories_table";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_1 + " ( Top_ID INTERGER PRIMARY KEY AUTOINCREMENT, Top_Name TEXT, Crop_Top BOOLEAN, TShirt BOOLEAN, TankTop BOOLEAN, Long_Sleeve_Flannel BOOLEAN, Collared_Shirt BOOLEAN, Dress_Shirt_Blouse BOOLEAN, Long_Dress BOOLEAN, Medium_Dress BOOLEAN, Short_Dress BOOLEAN, Shirt BOOLEAN, Dress BOOLEAN, BottomsRequired BOOLEAN)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        onCreate(db);

    }
}

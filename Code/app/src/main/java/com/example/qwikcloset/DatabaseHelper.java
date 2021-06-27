package com.example.qwikcloset;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Clothing.db";
    public static final String TABLE_1 = "Clothing_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_1 + " (ID INTERGER PRIMARY KEY AUTOINCREMENT, Category TEXT, Sub_Category TEXT , Specific_Category TEXT, Mood TEXT, Weather TEXT, Task TEXT, Color TEXT, Image BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        onCreate(db);

    }
}

package com.example.qwikcloset;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Clothing.db";
    public static final String TABLE_1 = "Clothing_table";
    public static final String TABLE_2 = "Outfit_table";

    public byte[] insertImg(Bitmap img ) {


        byte[] data = getBitmapAsByteArray(img); // this is a function
        return data;
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public Bitmap byteArrayToBitMap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public static Connection connect(String url){
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static byte[] readFile(File file){
        ByteArrayOutputStream bos = null;
        try{
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for(int len; (len = fis.read(buffer)) != -1;){
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e2){
            System.err.println(e2.getMessage());
        }

        return bos != null ? bos.toByteArray() : null;
    }

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Category TEXT, Sub_Category TEXT , Specific_Category TEXT, Mood TEXT, Temperature TEXT, Precipitation TEXT, Task TEXT, Color TEXT, Picture BLOB)");
        db.execSQL("CREATE TABLE " + TABLE_2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Tops INTEGER, Bottoms INTEGER, Shoes INTEGER, ACC1 INTEGER, ACC2 INTEGER, ACC3 INTEGER, Mood TEXT, Temperature TEXT, Precipitation TEXT, Task TEXT, Color TEXT, Rating INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_2);
        onCreate(db);

    }

    public boolean insertData_Clothing(String category, String subcategory, String specificCategory, String mood, String temperature, String precipitation, String task, String color, Bitmap picture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Category", category);
        contentValues.put("Sub_Category", subcategory);
        contentValues.put("Specific_Category", specificCategory);
        contentValues.put("Mood", mood);
        contentValues.put("Temperature", temperature);
        contentValues.put("Precipitation", precipitation);
        contentValues.put("Task", task);
        contentValues.put("Color", color);
        byte[] image = insertImg(picture);
        contentValues.put("Picture", image);
        //I feel as though we need to get the actual row number as an int instead of a long.
        long result = db.insert(TABLE_1, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData_Outfit(int tops, int bottoms, int shoes, int acc1, int acc2, int acc3,  String mood, String temperature, String precipitation, String task, String color, int rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Top", tops);
        contentValues.put("Bottom", bottoms);
        contentValues.put("Shoes", shoes);
        contentValues.put("ACC1", acc1);
        contentValues.put("ACC2", acc2);
        contentValues.put("ACC3", acc3);
        contentValues.put("Mood", mood);
        contentValues.put("Temperature", temperature);
        contentValues.put("Precipitation", precipitation);
        contentValues.put("Task", task);
        contentValues.put("Color", color);
        contentValues.put("Rating", rating);

        long result = db.insert(TABLE_2, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public ArrayList<ClothingItem> readClothingCursor(Cursor cursor, Context context){
        ArrayList<ClothingItem> list = new ArrayList<ClothingItem>();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String category = cursor.getString(cursor.getColumnIndex("Category"));
                String subCategory = cursor.getString(cursor.getColumnIndex("Sub_Category"));
                String specificCategory = cursor.getString(cursor.getColumnIndex("Specific_Category"));
                String mood = cursor.getString(cursor.getColumnIndex("Mood"));
                String temperature = cursor.getString(cursor.getColumnIndex("Temperature"));
                String precipitation = cursor.getString(cursor.getColumnIndex("Precipitation"));
                String task = cursor.getString(cursor.getColumnIndex("Task"));
                String color = cursor.getString(cursor.getColumnIndex("Color"));
                byte[] bytes = cursor.getBlob(cursor.getColumnIndex("Picture"));
                Drawable drawable = new BitmapDrawable(context.getResources(), byteArrayToBitMap(bytes));

                list.add(new ClothingItem(id, category, subCategory, specificCategory, mood, temperature, precipitation, task, color, drawable));

                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }

    public ArrayList<Outfit> readOutfitCursor(Cursor cursor, Context context){
        ArrayList<Outfit> list = new ArrayList<Outfit>();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String top_str = cursor.getString(cursor.getColumnIndex("Top"));
                String bottom_str = cursor.getString(cursor.getColumnIndex("Bottom"));
                String shoes_str = cursor.getString(cursor.getColumnIndex("Shoes"));
                String acc1_str = cursor.getString(cursor.getColumnIndex("ACC1"));
                String acc2_str = cursor.getString(cursor.getColumnIndex("ACC2"));
                String acc3_str = cursor.getString(cursor.getColumnIndex("ACC3"));
                String mood = cursor.getString(cursor.getColumnIndex("Mood"));
                String temperature = cursor.getString(cursor.getColumnIndex("Temperature"));
                String precipitation = cursor.getString(cursor.getColumnIndex("Precipitation"));
                String task = cursor.getString(cursor.getColumnIndex("Task"));
                String color = cursor.getString(cursor.getColumnIndex("Color"));
                Integer rating = cursor.getInt(cursor.getColumnIndex("Rating"));

                ClothingItem top = getSpecificData_Clothing(top_str, context);
                ClothingItem bottom = getSpecificData_Clothing(bottom_str, context);
                ClothingItem shoes = getSpecificData_Clothing(shoes_str, context);
                ClothingItem acc1 = getSpecificData_Clothing(acc1_str, context);
                ClothingItem acc2 = getSpecificData_Clothing(acc2_str, context);
                ClothingItem acc3 = getSpecificData_Clothing(acc3_str, context);


                list.add(new Outfit(top, bottom, shoes, acc1, acc2, acc3, mood, temperature, precipitation, task, color, rating));

                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }


    public ArrayList<ClothingItem> getAllData_Clothing(Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_1, null);
        ArrayList<ClothingItem> list = readClothingCursor(cursor, context);
        return list;
    }
    public ClothingItem getSpecificData_Clothing(String id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_1 + " WHERE id = ?", new String[] { id });
        ArrayList<ClothingItem> list = readClothingCursor(result, context);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    /*public CategoryItem getCategoryItem(Cursor cursor){
        CategoryItem categoryItem =
    }*/

    public Cursor getAllData_Outfit() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_2, null);
        return result;
    }

    public Cursor getSpecificData_Outfit(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_2 + " WHERE id = ?", new String[] { id });
        return result;
    }

    public boolean updateData_Outfit(String id, int tops, int bottoms, int shoes, int acc1, int acc2, int acc3,  String mood, String temperature, String precipitation, String task, String color, int rating, boolean saved ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("Top", tops);
        contentValues.put("Bottom", bottoms);
        contentValues.put("Shoes", shoes);
        contentValues.put("ACC1", acc1);
        contentValues.put("ACC2", acc2);
        contentValues.put("ACC3", acc3);
        contentValues.put("Mood", mood);
        contentValues.put("Temperature", temperature);
        contentValues.put("Precipitation", precipitation);
        contentValues.put("Task", task);
        contentValues.put("Color", color);
        contentValues.put("Rating", rating);
        contentValues.put("Saved", saved);
        db.update(TABLE_2, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public Integer deleteData_Clothing(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_1, "ID = ?", new String[] { id });

    }
    public Integer deleteData_Outfit(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_2, "ID = ?", new String[] { id });
    }
}

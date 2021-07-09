package com.example.qwikcloset;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Clothing.db";
    public static final String TABLE_1 = "Clothing_table";
    public static final String TABLE_2 = "Outfit_table";

    public static void updatePicture(long rowID, File file, String column, String url){
        String updateSQL = "UPDATE " + TABLE_1 + " " + "SET " + column + " = ? " + "WHERE id=?";

        try{
            Connection conn = connect(url);
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);

            pstmt.setBytes(1, readFile(file));
            pstmt.setLong(2, rowID);

            pstmt.executeUpdate();
            System.out.println("Stored the picture in the BLOB column.");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public byte[] insertImg(Bitmap img ) {


        byte[] data = getBitmapAsByteArray(img); // this is a function
        return data;
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public Bitmap getImage(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        String qu = "select img  from " + TABLE_1 + " where feedid =" + i ;
        Cursor cur = db.rawQuery(qu, null);

        if (cur.moveToFirst()){
            byte[] imgByte = cur.getBlob(0);
            cur.close();
            return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        }
        if (cur != null && !cur.isClosed()) {
            cur.close();
        }

        return null;
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
        db.execSQL("CREATE TABLE " + TABLE_1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Category TEXT, Sub_Category TEXT , Specific_Category TEXT, Mood TEXT, Weather TEXT, Task TEXT, Color TEXT, Picture BLOB)");
        db.execSQL("CREATE TABLE " + TABLE_2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Tops INTEGER, Bottoms INTEGER, Shoes INTEGER, ACC1 INTEGER, ACC2 INTEGER, ACC3 INTEGER, Mood TEXT, Weather TEXT, Task TEXT, Color TEXT, Rating INTEGER, Saved BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_2);
        onCreate(db);

    }

    public boolean insertData_Clothing(String category, String subcategory, String specificCategory, String mood, String weather, String task, String color, Bitmap picture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Category", category);
        contentValues.put("Sub_Category", subcategory);
        contentValues.put("Specific_Category", specificCategory);
        contentValues.put("Mood", mood);
        contentValues.put("Weather", weather);
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

    public boolean insertData_Outfit(int tops, int bottoms, int shoes, int acc1, int acc2, int acc3,  String mood, String weather, String task, String color, int rating, boolean saved) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Top", tops);
        contentValues.put("Bottom", bottoms);
        contentValues.put("Shoes", shoes);
        contentValues.put("ACC1", acc1);
        contentValues.put("ACC2", acc2);
        contentValues.put("ACC3", acc3);
        contentValues.put("Mood", mood);
        contentValues.put("Weather", weather);
        contentValues.put("Task", task);
        contentValues.put("Color", color);
        contentValues.put("Rating", rating);
        contentValues.put("Saved", saved);

        long result = db.insert(TABLE_2, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData_Clothing() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_1, null);
        return result;
    }
    public Cursor getSpecificData_Clothing(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_1 + " WHERE id = ?", new String[] { id });
        return result;
    }

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

    public boolean updateData_Outfit(String id, int tops, int bottoms, int shoes, int acc1, int acc2, int acc3,  String mood, String weather, String task, String color, int rating, boolean saved ){
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
        contentValues.put("Weather", weather);
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

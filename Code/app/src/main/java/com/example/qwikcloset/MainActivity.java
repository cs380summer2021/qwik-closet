package com.example.qwikcloset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.ByteArrayOutputStream;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private TextView mTextViewAmount;
    private int mAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        Button buttonEnterCloset = (Button) findViewById(R.id.enterYourCloset);

        buttonEnterCloset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "onClick: Clicked enterYourCloset.");

                Intent intent = new Intent(MainActivity.this,
                        TestingLayout.class);
                startActivity(intent);
            }
        });

        //mTextViewAmount = findViewById(R.id.textview_amount);
    }

    private void doThings() {
        //HOW TO USE: write a switch case for all of the functions you wish to run, leaving them an int to tell which one is which. So, if the screen says 0, it'll run case 0.
        //Make sure to include a break after each case.
        switch (mAmount) {
            case 0:
                String fileName = "Tit.jpg";
                String stringFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/" + fileName;
                Bitmap bitmap = BitmapFactory.decodeFile(stringFilePath);
                myDb.insertData_Clothing("1", "1", "1", "sad", "clear", "work", "bird", bitmap);
                break;
            default:
                break;
        }
    }

    public void toSecondView(View view) {
        Intent intentMain = new Intent(this ,
                com.example.qwikcloset.ClosetView.class);
        this.startActivity(intentMain);
    }


}
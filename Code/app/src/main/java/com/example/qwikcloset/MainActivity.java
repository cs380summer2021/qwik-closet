package com.example.qwikcloset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toSecondView(View view) {
        Intent intentMain = new Intent(this ,
                com.example.qwikcloset.ClosetView.class);
        this.startActivity(intentMain);
    }


}
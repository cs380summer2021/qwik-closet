package com.example.qwikcloset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private TextView mTextViewAmount;
    private int mAmount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        mTextViewAmount = findViewById(R.id.textview_amount);
        Button buttonIncrease = findViewById(R.id.button_increase);
        Button buttonDecrease = findViewById(R.id.button_decrease);
        Button buttonDothings = findViewById(R.id.button_doThings);

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });

        buttonDothings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doThings();
            }
        });
    }

    private void increase(){
        mAmount++;
        mTextViewAmount.setText(String.valueOf(mAmount));
    }

    private void decrease(){
        if(mAmount <= 0){
            return;
        }
        mAmount--;
        mTextViewAmount.setText(String.valueOf(mAmount));
    }

    private void doThings(){
        //HOW TO USE: write a switch case for all of the functions you wish to run, leaving them an int to tell which one is which. So, if the screen says 0, it'll run case 0.
        //Make sure to include a break after each case.
        switch (mAmount){
            case 0:
                int[] clothingType = LookUpMaps.map("T-shirt");
                break;
            default:
                break;
        }
    }
}
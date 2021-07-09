package com.example.qwikcloset;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ClothingItemView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothingitem);
    }

    public void toSecondView(View view) {
        Intent intentMain = new Intent(this,
                com.example.qwikcloset.ClothingItemView.class);
        this.startActivity(intentMain);
    }

}

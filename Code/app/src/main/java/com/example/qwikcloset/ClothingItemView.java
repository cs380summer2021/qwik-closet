package com.example.qwikcloset;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ClothingItemView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothingitem);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("id")){
            ClothingItem clothingItem = new DatabaseHelper(this).getSpecificData_Clothing(getIntent().getStringExtra("id"), this);

            TextView title = findViewById(R.id.clothingTitle);
            ImageView picture = findViewById(R.id.clothing_image);
            TextView clothingType = findViewById(R.id.clothing_type);
            TextView clothingColor = findViewById(R.id.clothing_color);
            TextView clothingWeather = findViewById(R.id.clothingWeather);
            TextView clothingMood = findViewById(R.id.clothingMood);
            TextView clothingTask = findViewById(R.id.clothingTask);

            title.setText("");
            picture.setImageDrawable(clothingItem.picture);
            clothingType.setText(LookUpMaps.map(Integer.parseInt(clothingItem.category), Integer.parseInt(clothingItem.subCategory), Integer.parseInt(clothingItem.specificCategory)));
            clothingColor.setText(clothingItem.color);
            clothingWeather.setText(clothingItem.weather);
            clothingMood.setText(clothingItem.mood);
            clothingTask.setText(clothingItem.task);

        }
        else{
            TextView title = findViewById(R.id.clothingTitle);
            title.setText("ERROR");
        }
    }

    public void toSecondView(View view) {
        Intent intentMain = new Intent(this,
                com.example.qwikcloset.ClothingItemView.class);
        this.startActivity(intentMain);
    }

}

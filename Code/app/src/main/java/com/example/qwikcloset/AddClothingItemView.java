package com.example.qwikcloset;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddClothingItemView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclothingitem);

        ImageView previewImage = findViewById(R.id.add_clothing_preview_image);
        TextView clothingType = findViewById(R.id.add_clothing_selected_clothing_type);
        TextView clothingMood = findViewById(R.id.add_clothing_selected_mood);
        TextView clothingTemperature = findViewById(R.id.add_clothing_selected_temperature);
        TextView clothingPrecipitation = findViewById(R.id.add_clothing_selected_precipitation);
        TextView clothingTask = findViewById(R.id.add_clothing_selected_task);
        
    }
}

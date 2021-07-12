package com.example.qwikcloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OutfitView extends AppCompatActivity{
    Outfit outfit;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_view);

        TextView title = findViewById(R.id.outfit_view_title);

        ImageView top = findViewById(R.id.outfit_view_preview_top);
        ImageView bottom = findViewById(R.id.outfit_view_preview_bottom);
        ImageView shoes = findViewById(R.id.outfit_view_preview_shoes);
        ImageView accessory1 = findViewById(R.id.outfit_view_preview_accessory1);
        ImageView accessory2 = findViewById(R.id.outfit_view_preview_accessory2);
        ImageView accessory3 = findViewById(R.id.outfit_view_preview_accessory3);

        ArrayList<ImageView> images = new ArrayList<>();
        images.add(top);
        images.add(bottom);
        images.add(shoes);
        images.add(accessory1);
        images.add(accessory2);
        images.add(accessory3);

        TextView mood = findViewById(R.id.outfit_view_mood);
        TextView temperature = findViewById(R.id.outfit_view_temperature);
        TextView precipitation = findViewById(R.id.outfit_view_precipitation);
        TextView task = findViewById(R.id.outfit_view_task);
        TextView color = findViewById(R.id.outfit_view_color);

        getIncomingIntent();

        if(outfit == null){
            return;
        }

        title.setText("Outfit #" + outfit.id);

        for(int i = 0; i < images.size(); ++i){
            if(outfit.clothing.get(i) != null){
                images.get(i).setImageDrawable(outfit.clothing.get(i).picture);
            }
            else{
                images.get(i).setVisibility(View.GONE);
            }
        }

        mood.setText(outfit.mood);
        temperature.setText(outfit.temperature);
        precipitation.setText(outfit.precipitation);
        task.setText(outfit.task);
        color.setText(outfit.color);

    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("outfitId")){
            String s = getIntent().getStringExtra("outfitId");
            DatabaseHelper myDb = new DatabaseHelper(this);
            Outfit o = myDb.readOutfitCursor(myDb.getSpecificData_Outfit(s), this).get(0);
            if(o != null){
               outfit = o;
            }
        }
        else{
            TextView t = findViewById(R.id.outfit_view_title);
            t.setText("ERROR");
        }
    }
}

package com.example.qwikcloset;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenuView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button buttonCloset = findViewById(R.id.menu_go_to_closet_view);
        Button buttonAddClothing = findViewById(R.id.menu_go_to_add_clothing);
        Button buttonBuildOutfit = findViewById(R.id.menu_go_to_build_outfit);
        Button buttonViewOutfits = findViewById(R.id.menu_go_to_outfit_gallery_view);

        buttonCloset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuView.this, ClosetView.class);
                startActivity(intent);
            }
        });

        buttonAddClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuView.this, AddClothingItemView.class);
                startActivity(intent);
            }
        });

        buttonBuildOutfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuView.this, BuildOutfitView.class);
                startActivity(intent);
            }
        });

        buttonViewOutfits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuView.this, OutfitGalleryView.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.qwikcloset;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BuildOutfitView extends AppCompatActivity {
    ImageButton topPreview;
    ImageButton bottomPreview;
    ImageButton shoesPreview;
    ImageButton accessory1Preview;
    ImageButton accessory2Preview;
    ImageButton accessory3Preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addoutfit);

        topPreview = findViewById(R.id.build_outfit_preview_top);
        
        
        /*TextView clothingMood = findViewById(R.id.build_outfit_selected_mood);
        TextView clothingTemperature = findViewById(R.id.build_outfit_selected_temperature);
        TextView clothingPrecipitation = findViewById(R.id.build_outfit_selected_precipitation);
        TextView clothingTask = findViewById(R.id.build_outfit_selected_task);
        TextView clothingColor = findViewById(R.id.build_outfit_selected_color);

        ArrayList<String> defaultAnswers = new ArrayList<String>();
        defaultAnswers.add((String) clothingMood.getText());
        defaultAnswers.add((String) clothingTemperature.getText());
        defaultAnswers.add((String) clothingPrecipitation.getText());
        defaultAnswers.add((String) clothingTask.getText());
        defaultAnswers.add((String) clothingColor.getText());

        Button buttonTakePicture = findViewById(R.id.build_outfit_take_picture);
        Button buttonAddImage = findViewById(R.id.build_outfit_add_image);
        ArrayList<Button> pictures = new ArrayList<Button>();
        pictures.add(buttonTakePicture);
        pictures.add(buttonAddImage);

        TextView moodPrompter = findViewById(R.id.build_outfit_mood_prompter);
        Button buttonSad = findViewById(R.id.build_outfit_sad);
        Button buttonConfident = findViewById(R.id.build_outfit_confident);
        Button buttonRelaxed = findViewById(R.id.build_outfit_relaxed);
        Button buttonHappy = findViewById(R.id.build_outfit_happy);
        Button buttonNoEmotion = findViewById(R.id.build_outfit_no_emotion);
        ArrayList<Button> moods = new ArrayList<Button>();
        moods.add(buttonSad);
        moods.add(buttonConfident);
        moods.add(buttonRelaxed);
        moods.add(buttonHappy);
        moods.add(buttonNoEmotion);


        TextView temperaturePrompter = findViewById(R.id.build_outfit_temperature_prompter);
        Button buttonHot = findViewById(R.id.build_outfit_hot);
        Button buttonWarm = findViewById(R.id.build_outfit_warm);
        Button buttonTemperate = findViewById(R.id.build_outfit_temperate);
        Button buttonCold = findViewById(R.id.build_outfit_cold);
        Button buttonFreezing  = findViewById(R.id.build_outfit_freezing);
        Button buttonNoTemperature = findViewById(R.id.build_outfit_no_temperature);
        ArrayList<Button> temperatures = new ArrayList<Button>();
        temperatures.add(buttonHot);
        temperatures.add(buttonWarm);
        temperatures.add(buttonTemperate);
        temperatures.add(buttonCold);
        temperatures.add(buttonFreezing);
        temperatures.add(buttonNoTemperature);

        TextView precipitationPrompter = findViewById(R.id.build_outfit_precipitation_prompter);
        Button buttonClear = findViewById(R.id.build_outfit_clear);
        Button buttonCloudy = findViewById(R.id.build_outfit_cloudy);
        Button buttonRaining = findViewById(R.id.build_outfit_raining);
        Button buttonSnowing = findViewById(R.id.build_outfit_snowing);
        Button buttonNoPrecipitation = findViewById(R.id.build_outfit_no_precipitation);
        ArrayList<Button> precipitations = new ArrayList<Button>();
        precipitations.add(buttonClear);
        precipitations.add(buttonCloudy);
        precipitations.add(buttonRaining);
        precipitations.add(buttonSnowing);
        precipitations.add(buttonNoPrecipitation);

        TextView taskPrompter = findViewById(R.id.build_outfit_task_prompter);
        Button buttonBusiness = findViewById(R.id.build_outfit_business);
        Button buttonLabor = findViewById(R.id.build_outfit_labor);
        Button buttonCasual = findViewById(R.id.build_outfit_casual);
        Button buttonParty = findViewById(R.id.build_outfit_party);
        Button buttonElegant = findViewById(R.id.build_outfit_elegant);
        Button buttonActive = findViewById(R.id.build_outfit_active);
        Button buttonNoTask = findViewById(R.id.build_outfit_no_task);
        ArrayList<Button> tasks = new ArrayList<Button>();
        tasks.add(buttonBusiness);
        tasks.add(buttonLabor);
        tasks.add(buttonCasual);
        tasks.add(buttonParty);
        tasks.add(buttonElegant);
        tasks.add(buttonActive);
        tasks.add(buttonNoTask);

        TextView colorPrompter = findViewById(R.id.build_outfit_color_prompter);
        Button buttonAqua = findViewById(R.id.build_outfit_aqua);
        Button buttonBlack = findViewById(R.id.build_outfit_black);
        Button buttonBlue = findViewById(R.id.build_outfit_blue);
        Button buttonBrown = findViewById(R.id.build_outfit_brown);
        Button buttonFuchsia = findViewById(R.id.build_outfit_fuchsia);
        Button buttonGrey = findViewById(R.id.build_outfit_grey);
        Button buttonGreen = findViewById(R.id.build_outfit_green);
        Button buttonLightBlue = findViewById(R.id.build_outfit_light_blue);
        Button buttonLime = findViewById(R.id.build_outfit_lime);
        Button buttonMaroon = findViewById(R.id.build_outfit_maroon);
        Button buttonNavyBlue = findViewById(R.id.build_outfit_navy_blue);
        Button buttonOlive = findViewById(R.id.build_outfit_olive);
        Button buttonOrange = findViewById(R.id.build_outfit_orange);
        Button buttonPink = findViewById(R.id.build_outfit_pink);
        Button buttonPurple = findViewById(R.id.build_outfit_purple);
        Button buttonRed = findViewById(R.id.build_outfit_red);
        Button buttonSilver = findViewById(R.id.build_outfit_silver);
        Button buttonTan = findViewById(R.id.build_outfit_tan);
        Button buttonTeal = findViewById(R.id.build_outfit_teal);
        Button buttonWhite = findViewById(R.id.build_outfit_white);
        Button buttonYellow = findViewById(R.id.build_outfit_yellow);
        Button buttonNoColor = findViewById(R.id.build_outfit_no_color);
        ArrayList<Button> colors = new ArrayList<Button>();
        colors.add(buttonAqua);
        colors.add(buttonBlack);
        colors.add(buttonBlue);
        colors.add(buttonBrown);
        colors.add(buttonFuchsia);
        colors.add(buttonGrey);
        colors.add(buttonGreen);
        colors.add(buttonLightBlue);
        colors.add(buttonLime);
        colors.add(buttonMaroon);
        colors.add(buttonNavyBlue);
        colors.add(buttonOlive);
        colors.add(buttonOrange);
        colors.add(buttonPink);
        colors.add(buttonPurple);
        colors.add(buttonRed);
        colors.add(buttonSilver);
        colors.add(buttonTan);
        colors.add(buttonTeal);
        colors.add(buttonWhite);
        colors.add(buttonYellow);
        colors.add(buttonNoColor);

        Button buttonSave = findViewById(R.id.build_outfit_saveItem);

        for(int i = 0; i < clothingTypes.size(); ++i){
            Button tempButton = clothingTypes.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clothingType.setText(tempButton.getText());
                    clothingTypePrompter.setText("(+) "  + clothingTypePrompter.getText());
                    for(int j = 0; j < clothingTypes.size(); ++j){
                        clothingTypes.get(j).setVisibility(View.GONE);
                    }
                }
            });
        }

        clothingTypePrompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clothingType.setText("Clothing Type: None Selected");
                String s = (String) clothingTypePrompter.getText();
                s = s.split(" ", 2)[1];
                clothingTypePrompter.setText(s);

                for(int i = 0; i < clothingTypes.size(); ++i){
                    clothingTypes.get(i).setVisibility(View.VISIBLE);
                }
            }
        });

        for(int i = 0; i < moods.size(); ++i){
            Button tempButton = moods.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clothingMood.setText(tempButton.getText());
                    moodPrompter.setText("(+) "  + clothingMood.getText());
                    for(int j = 0; j < moods.size(); ++j){
                        moods.get(j).setVisibility(View.GONE);
                    }
                }
            });
        }

        moodPrompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clothingMood.setText("Mood: None Selected");
                String s = (String) moodPrompter.getText();
                s = s.split(" ", 2)[1];
                moodPrompter.setText(s);

                for(int i = 0; i < moods.size(); ++i){
                    moods.get(i).setVisibility(View.VISIBLE);
                }
            }
        });

        for(int i = 0; i < temperatures.size(); ++i){
            Button tempButton = temperatures.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clothingTemperature.setText(tempButton.getText());
                    temperaturePrompter.setText("(+) "  + temperaturePrompter.getText());
                    for(int j = 0; j < temperatures.size(); ++j){
                        temperatures.get(j).setVisibility(View.GONE);
                    }
                }
            });
        }

        temperaturePrompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clothingTemperature.setText("Temperature: None Selected");
                String s = (String) temperaturePrompter.getText();
                s = s.split(" ", 2)[1];
                temperaturePrompter.setText(s);

                for(int i = 0; i < temperatures.size(); ++i){
                    temperatures.get(i).setVisibility(View.VISIBLE);
                }
            }
        });

        for(int i = 0; i < precipitations.size(); ++i){
            Button tempButton = precipitations.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clothingPrecipitation.setText(tempButton.getText());
                    precipitationPrompter.setText("(+) "  + precipitationPrompter.getText());
                    for(int j = 0; j < precipitations.size(); ++j){
                        precipitations.get(j).setVisibility(View.GONE);
                    }
                }
            });
            myDb = new DatabaseHelper(this);
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int[] categoryNumbers = LookUpMaps.map((String) clothingType.getText());
                    ArrayList<String> list = new ArrayList<String>();
                    list.add((String) clothingMood.getText());
                    list.add((String) clothingTemperature.getText());
                    list.add((String) clothingPrecipitation.getText());
                    list.add((String) clothingTask.getText());
                    list.add((String) clothingColor.getText());
                    Drawable drawable = previewImage.getDrawable();

                    if(categoryNumbers == null){
                        Toast.makeText(AddClothingItemView.this, "You need to fill out all categories", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    for(int i = 0; i < list.size(); ++i){
                        if(list.get(i) == null || list.get(i).equals(defaultAnswers.get(i))){
                            Toast.makeText(AddClothingItemView.this, "You need to fill out all categories", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    if (drawable == null){
                        Toast.makeText(AddClothingItemView.this, "You need to insert a picture.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    myDb.insertData_Clothing(("" + categoryNumbers[0]), ("" + categoryNumbers[1]), ("" + categoryNumbers[2]), list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), bitmapDrawable.getBitmap());
                    Intent intent = new Intent(AddClothingItemView.this, MainMenuView.class);
                    startActivity(intent);
                }
            });
        }

        precipitationPrompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clothingPrecipitation.setText("Precipitation: None Selected");
                String s = (String) precipitationPrompter.getText();
                s = s.split(" ", 2)[1];
                precipitationPrompter.setText(s);

                for(int i = 0; i < precipitations.size(); ++i){
                    precipitations.get(i).setVisibility(View.VISIBLE);
                }
            }
        });

        for(int i = 0; i < tasks.size(); ++i){
            Button tempButton = tasks.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clothingTask.setText(tempButton.getText());
                    taskPrompter.setText("(+) "  + taskPrompter.getText());
                    for(int j = 0; j < tasks.size(); ++j){
                        tasks.get(j).setVisibility(View.GONE);
                    }
                }
            });
        }

        taskPrompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clothingTask.setText("Task: None Selected");
                String s = (String) taskPrompter.getText();
                s = s.split(" ", 2)[1];
                taskPrompter.setText(s);

                for(int i = 0; i < tasks.size(); ++i){
                    tasks.get(i).setVisibility(View.VISIBLE);
                }
            }
        });

        for(int i = 0; i < colors.size(); ++i){
            Button tempButton = colors.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clothingColor.setText(tempButton.getText());
                    colorPrompter.setText("(+) "  + colorPrompter.getText());
                    for(int j = 0; j < colors.size(); ++j){
                        colors.get(j).setVisibility(View.GONE);
                    }
                }
            });
        }

        colorPrompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clothingColor.setText("Color: None Selected");
                String s = (String) colorPrompter.getText();
                s = s.split(" ", 2)[1];
                colorPrompter.setText(s);

                for(int i = 0; i < colors.size(); ++i){
                    colors.get(i).setVisibility(View.VISIBLE);
                }
            }
        });*/
    }
}

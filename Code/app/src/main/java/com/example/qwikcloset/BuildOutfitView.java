package com.example.qwikcloset;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BuildOutfitView extends AppCompatActivity {
    ImageButton topPreview;
    ImageButton bottomPreview;
    ImageButton shoesPreview;
    ImageButton accessory1Preview;
    ImageButton accessory2Preview;
    ImageButton accessory3Preview;

    DatabaseHelper myDb;
    int LAUNCH_SECOND_ACTIVITY = 1;

    ArrayList<ImageButton> previews;
    ArrayList<Button> setButtons;
    ArrayList<TextView> ids;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LAUNCH_SECOND_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                ClothingItem clothingItem = myDb.getSpecificData_Clothing(data.getStringExtra("result"), this);
                int slot = Integer.parseInt(data.getStringExtra("slot"));
                ids.get(slot).setText(("" + clothingItem.id));
                previews.get(slot).setImageDrawable(clothingItem.picture);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addoutfit);

        topPreview = findViewById(R.id.build_outfit_preview_top);
        bottomPreview = findViewById(R.id.build_outfit_preview_bottom);
        shoesPreview = findViewById(R.id.build_outfit_preview_shoes);
        accessory1Preview = findViewById(R.id.build_outfit_preview_accessory1);
        accessory2Preview = findViewById(R.id.build_outfit_preview_accessory2);
        accessory3Preview = findViewById(R.id.build_outfit_preview_accessory3);
        previews = new ArrayList<ImageButton>();
        previews.add(topPreview);
        previews.add(bottomPreview);
        previews.add(shoesPreview);
        previews.add(accessory1Preview);
        previews.add(accessory2Preview);
        previews.add(accessory3Preview);

        Button buttonSetTop = findViewById(R.id.build_outfit_select_top);
        Button buttonSetBottom = findViewById(R.id.build_outfit_select_bottom);
        Button buttonSetShoes = findViewById(R.id.build_outfit_select_shoes);
        Button buttonSetAccessory1 = findViewById(R.id.build_outfit_select_accessory1);
        Button buttonSetAccessory2 = findViewById(R.id.build_outfit_select_accessory2);
        Button buttonSetAccessory3 = findViewById(R.id.build_outfit_select_accessory3);
        setButtons = new ArrayList<Button>();
        setButtons.add(buttonSetTop);
        setButtons.add(buttonSetBottom);
        setButtons.add(buttonSetShoes);
        setButtons.add(buttonSetAccessory1);
        setButtons.add(buttonSetAccessory2);
        setButtons.add(buttonSetAccessory3);

        TextView topId = findViewById(R.id.build_outfit_selected_top_id);
        TextView bottomId = findViewById(R.id.build_outfit_selected_bottom_id);
        TextView shoesId = findViewById(R.id.build_outfit_selected_shoe_id);
        TextView accessory1Id = findViewById(R.id.build_outfit_selected_accessory1_id);
        TextView accessory2Id = findViewById(R.id.build_outfit_selected_accessory2_id);
        TextView accessory3Id = findViewById(R.id.build_outfit_selected_accessory3_id);
        ids = new ArrayList<TextView>();
        ids.add(topId);
        ids.add(bottomId);
        ids.add(shoesId);
        ids.add(accessory1Id);
        ids.add(accessory2Id);
        ids.add(accessory3Id);

        /*for(int i = 0; i < ids.size(); ++i){
            ids.get(i).setVisibility(View.VISIBLE);
        }*/


        for(int i = 0; i < setButtons.size(); ++i){
            Button tempButton = setButtons.get(i);
            int finalI = i;
            tempButton.setOnClickListener(new View.OnClickListener() {
            String[] categories = new String[]{"1", "2", "3", "4", "4", "4"};
            String s = categories[finalI];
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BuildOutfitView.this, BuildOutfitClothingSelectionView.class);
                    intent.putExtra("id", s);
                    intent.putExtra("slot", (""+ finalI));
                    startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);
                }
            });
        }

        for(int i = 0; i < previews.size(); ++i){
            ImageButton tempButton = previews.get(i);
            TextView tempText = ids.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tempButton.setImageResource(android.R.color.transparent);
                    tempText.setText("None Selected");
                }
            });
        }


        TextView clothingMood = findViewById(R.id.build_outfit_selected_mood);
        TextView clothingTemperature = findViewById(R.id.build_outfit_selected_temperature);
        TextView clothingPrecipitation = findViewById(R.id.build_outfit_selected_precipitation);
        TextView clothingTask = findViewById(R.id.build_outfit_selected_task);
        TextView clothingColor = findViewById(R.id.build_outfit_selected_color);
        ArrayList<TextView> outfitProperties = new ArrayList<>();
        outfitProperties.add(clothingMood);
        outfitProperties.add(clothingTemperature);
        outfitProperties.add(clothingPrecipitation);
        outfitProperties.add(clothingTask);
        outfitProperties.add(clothingColor);

        ArrayList<String> defaultAnswers = new ArrayList<String>();
        defaultAnswers.add((String) clothingMood.getText());
        defaultAnswers.add((String) clothingTemperature.getText());
        defaultAnswers.add((String) clothingPrecipitation.getText());
        defaultAnswers.add((String) clothingTask.getText());
        defaultAnswers.add((String) clothingColor.getText());

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

        Button buttonSave = findViewById(R.id.build_outfit_save_outfit);

        for(int i = 0; i < moods.size(); ++i){
            Button tempButton = moods.get(i);
            tempButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clothingMood.setText(tempButton.getText());
                    moodPrompter.setText("(+) "  + moodPrompter.getText());
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
                    //int[] categoryNumbers = LookUpMaps.map((String) clothingType.getText());
                    ArrayList<String> list = new ArrayList<String>();
                    for(int i = 0; i < ids.size(); ++i){
                        if("None Selected".equals((String) ids.get(i).getText())){
                            list.add("-1");
                            continue;
                        }
                        list.add((String) ids.get(i).getText());
                    }

                    if(list.get(0) == null || list.get(0) == "None Selected" || list.get(0) == "-1"){
                        Toast.makeText(BuildOutfitView.this, "You need to select a top", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(list.get(1) == null || list.get(1) == "None Selected" || list.get(1) == "-1"){
                        ClothingItem temp = myDb.getSpecificData_Clothing(list.get(1), BuildOutfitView.this);
                        if(!temp.category.equals("1") || !temp.subCategory.equals("2")){
                            Toast.makeText(BuildOutfitView.this, "Dress not selected, bottom required.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    if(list.get(2) == null || list.get(2) == "None Selected" || list.get(0) == "-1"){
                        Toast.makeText(BuildOutfitView.this, "You need to select a shoe.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    for(int i = 0; i < outfitProperties.size(); ++i){
                        if(defaultAnswers.get(i).equals((String) outfitProperties.get(i).getText())){
                            Toast.makeText(BuildOutfitView.this, "You need to select the other properties.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }



                    //myDb.insertData_Clothing(("" + categoryNumbers[0]), ("" + categoryNumbers[1]), ("" + categoryNumbers[2]), list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), bitmapDrawable.getBitmap());
                    myDb.insertData_Outfit(new Integer(list.get(0)), new Integer(list.get(1)), new Integer(list.get(2)), new Integer(list.get(3)), new Integer(list.get(4)), new Integer(list.get(5)), (String) outfitProperties.get(0).getText(), (String) outfitProperties.get(1).getText(), (String) outfitProperties.get(2).getText(), (String) outfitProperties.get(3).getText(), (String) outfitProperties.get(4).getText(), new Integer(0));
                    Intent intent = new Intent(BuildOutfitView.this, MainMenuView.class);
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
        });
    }
}

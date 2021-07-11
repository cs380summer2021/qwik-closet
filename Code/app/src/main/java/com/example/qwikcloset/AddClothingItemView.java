package com.example.qwikcloset;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddClothingItemView extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    private static int CAMERA_PIC_REQUEST = 1337;
    public ImageView previewImage;
    public DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclothingitem);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);

        previewImage = findViewById(R.id.add_clothing_preview_image);
        TextView clothingType = findViewById(R.id.add_clothing_selected_clothing_type);
        TextView clothingMood = findViewById(R.id.add_clothing_selected_mood);
        TextView clothingTemperature = findViewById(R.id.add_clothing_selected_temperature);
        TextView clothingPrecipitation = findViewById(R.id.add_clothing_selected_precipitation);
        TextView clothingTask = findViewById(R.id.add_clothing_selected_task);
        TextView clothingColor = findViewById(R.id.add_clothing_selected_color);

        Button buttonTakePicture = findViewById(R.id.add_clothing_take_picture);
        Button buttonAddImage = findViewById(R.id.add_clothing_add_image);
        ArrayList<Button> pictures = new ArrayList<Button>();
        pictures.add(buttonTakePicture);
        pictures.add(buttonAddImage);

        TextView clothingTypePrompter = findViewById(R.id.add_clothing_clothing_type_prompter);
        Button buttonCropTop = findViewById(R.id.add_clothing_crop_top_button);
        Button buttonTShirt = findViewById(R.id.add_clothing_t_shirt_button);
        Button buttonTankTop = findViewById(R.id.add_clothing_tank_top);
        Button buttonLongSleeve = findViewById(R.id.add_clothing_long_sleeve_shirt);
        Button buttonLongFlannel = findViewById(R.id.add_clothing_long_sleeve_flannel);
        Button buttonCollaredShirt = findViewById(R.id.add_clothing_collared_shirt);
        Button buttonDressShirt = findViewById(R.id.add_clothing_dress_shirt);
        Button buttonBlouse = findViewById(R.id.add_clothing_blouse);
        Button buttonLongDress = findViewById(R.id.add_clothing_long_dress);
        Button buttonMediumDress = findViewById(R.id.add_clothing_medium_dress);
        Button buttonShortDress = findViewById(R.id.add_clothing_short_dress);
        Button buttonJeans = findViewById(R.id.add_clothing_jeans);
        Button buttonSlacks = findViewById(R.id.add_clothing_slacks);
        Button buttonLeggings = findViewById(R.id.add_clothing_leggings);
        Button buttonCargoPants = findViewById(R.id.add_clothing_cargo_pants);
        Button buttonSportShorts = findViewById(R.id.add_clothing_sport_short);
        Button buttonBootyShorts = findViewById(R.id.add_clothing_booty_shorts);
        Button buttonJeanShorts = findViewById(R.id.add_clothing_jean_shorts);
        Button buttonTightSkirt = findViewById(R.id.add_clothing_tight_skirt);
        Button buttonStraightSkirt = findViewById(R.id.add_clothing_straight_skirt);
        Button buttonPleatedSkirt = findViewById(R.id.add_clothing_pleat_skirt);
        Button buttonFlowySkirt = findViewById(R.id.add_clothing_flowy_skirt);
        Button buttonTennisShoes = findViewById(R.id.add_clothing_tennis_shoes);
        Button buttonBoots = findViewById(R.id.add_clothing_boots);
        Button buttonDressShoes = findViewById(R.id.add_clothing_dress_shoes);
        Button buttonHeels = findViewById(R.id.add_clothing_heels);
        Button buttonWedges = findViewById(R.id.add_clothing_wedges);
        Button buttonOpenToeShoes = findViewById(R.id.add_clothing_open_toed_shoes);
        Button buttonHighTops = findViewById(R.id.add_clothing_high_tops);
        Button buttonJacket = findViewById(R.id.add_clothing_jacket);
        Button buttonJewelry = findViewById(R.id.add_clothing_jewelry);
        Button buttonMakeup = findViewById(R.id.add_clothing_makeup);
        Button buttonHats = findViewById(R.id.add_clothing_hat);
        Button buttonSunglasses = findViewById(R.id.add_clothing_sunglasses);
        ArrayList<Button> clothingTypes = new ArrayList<Button>();
        clothingTypes.add(buttonCropTop);
        clothingTypes.add(buttonTShirt);
        clothingTypes.add(buttonTankTop);
        clothingTypes.add(buttonLongSleeve);
        clothingTypes.add(buttonLongFlannel);
        clothingTypes.add(buttonCollaredShirt);
        clothingTypes.add(buttonDressShirt);
        clothingTypes.add(buttonBlouse);
        clothingTypes.add(buttonLongDress);
        clothingTypes.add(buttonMediumDress);
        clothingTypes.add(buttonShortDress);
        clothingTypes.add(buttonJeans);
        clothingTypes.add(buttonSlacks);
        clothingTypes.add(buttonLeggings);
        clothingTypes.add(buttonCargoPants);
        clothingTypes.add(buttonSportShorts);
        clothingTypes.add(buttonBootyShorts);
        clothingTypes.add(buttonJeanShorts);
        clothingTypes.add(buttonTightSkirt);
        clothingTypes.add(buttonStraightSkirt);
        clothingTypes.add(buttonPleatedSkirt);
        clothingTypes.add(buttonFlowySkirt);
        clothingTypes.add(buttonTennisShoes);
        clothingTypes.add(buttonBoots);
        clothingTypes.add(buttonDressShoes);
        clothingTypes.add(buttonHeels);
        clothingTypes.add(buttonWedges);
        clothingTypes.add(buttonOpenToeShoes);
        clothingTypes.add(buttonHighTops);
        clothingTypes.add(buttonJacket);
        clothingTypes.add(buttonJewelry);
        clothingTypes.add(buttonMakeup);
        clothingTypes.add(buttonHats);
        clothingTypes.add(buttonSunglasses);

        TextView moodPrompter = findViewById(R.id.add_clothing_mood_prompter);
        Button buttonSad = findViewById(R.id.add_clothing_sad);
        Button buttonConfident = findViewById(R.id.add_clothing_confident);
        Button buttonRelaxed = findViewById(R.id.add_clothing_relaxed);
        Button buttonHappy = findViewById(R.id.add_clothing_happy);
        Button buttonNoEmotion = findViewById(R.id.add_clothing_no_emotion);
        ArrayList<Button> moods = new ArrayList<Button>();
        moods.add(buttonSad);
        moods.add(buttonConfident);
        moods.add(buttonRelaxed);
        moods.add(buttonHappy);
        moods.add(buttonNoEmotion);


        TextView temperaturePrompter = findViewById(R.id.add_clothing_temperature_prompter);
        Button buttonHot = findViewById(R.id.add_clothing_hot);
        Button buttonWarm = findViewById(R.id.add_clothing_warm);
        Button buttonTemperate = findViewById(R.id.add_clothing_temperate);
        Button buttonCold = findViewById(R.id.add_clothing_cold);
        Button buttonFreezing  = findViewById(R.id.add_clothing_freezing);
        Button buttonNoTemperature = findViewById(R.id.add_clothing_no_temperature);
        ArrayList<Button> temperatures = new ArrayList<Button>();
        temperatures.add(buttonHot);
        temperatures.add(buttonWarm);
        temperatures.add(buttonTemperate);
        temperatures.add(buttonCold);
        temperatures.add(buttonFreezing);
        temperatures.add(buttonNoTemperature);

        TextView precipitationPrompter = findViewById(R.id.add_clothing_precipitation_prompter);
        Button buttonClear = findViewById(R.id.add_clothing_clear);
        Button buttonCloudy = findViewById(R.id.add_clothing_cloudy);
        Button buttonRaining = findViewById(R.id.add_clothing_raining);
        Button buttonSnowing = findViewById(R.id.add_clothing_snowing);
        Button buttonNoPrecipitation = findViewById(R.id.add_clothing_no_precipitation);
        ArrayList<Button> precipitations = new ArrayList<Button>();
        precipitations.add(buttonClear);
        precipitations.add(buttonCloudy);
        precipitations.add(buttonRaining);
        precipitations.add(buttonSnowing);
        precipitations.add(buttonNoPrecipitation);

        TextView taskPrompter = findViewById(R.id.add_clothing_task_prompter);
        Button buttonBusiness = findViewById(R.id.add_clothing_business);
        Button buttonLabor = findViewById(R.id.add_clothing_labor);
        Button buttonCasual = findViewById(R.id.add_clothing_casual);
        Button buttonParty = findViewById(R.id.add_clothing_party);
        Button buttonElegant = findViewById(R.id.add_clothing_elegant);
        Button buttonActive = findViewById(R.id.add_clothing_active);
        Button buttonNoTask = findViewById(R.id.add_clothing_no_task);
        ArrayList<Button> tasks = new ArrayList<Button>();
        tasks.add(buttonBusiness);
        tasks.add(buttonLabor);
        tasks.add(buttonCasual);
        tasks.add(buttonParty);
        tasks.add(buttonElegant);
        tasks.add(buttonActive);
        tasks.add(buttonNoTask);

        TextView colorPrompter = findViewById(R.id.add_clothing_color_prompter);
        Button buttonAqua = findViewById(R.id.add_clothing_aqua);
        Button buttonBlack = findViewById(R.id.add_clothing_black);
        Button buttonBlue = findViewById(R.id.add_clothing_blue);
        Button buttonBrown = findViewById(R.id.add_clothing_brown);
        Button buttonFuchsia = findViewById(R.id.add_clothing_fuchsia);
        Button buttonGrey = findViewById(R.id.add_clothing_grey);
        Button buttonGreen = findViewById(R.id.add_clothing_green);
        Button buttonLightBlue = findViewById(R.id.add_clothing_light_blue);
        Button buttonLime = findViewById(R.id.add_clothing_lime);
        Button buttonMaroon = findViewById(R.id.add_clothing_maroon);
        Button buttonNavyBlue = findViewById(R.id.add_clothing_navy_blue);
        Button buttonOlive = findViewById(R.id.add_clothing_olive);
        Button buttonOrange = findViewById(R.id.add_clothing_orange);
        Button buttonPink = findViewById(R.id.add_clothing_pink);
        Button buttonPurple = findViewById(R.id.add_clothing_purple);
        Button buttonRed = findViewById(R.id.add_clothing_red);
        Button buttonSilver = findViewById(R.id.add_clothing_silver);
        Button buttonTan = findViewById(R.id.add_clothing_tan);
        Button buttonTeal = findViewById(R.id.add_clothing_teal);
        Button buttonWhite = findViewById(R.id.add_clothing_white);
        Button buttonYellow = findViewById(R.id.add_clothing_yellow);
        Button buttonNoColor = findViewById(R.id.add_clothing_no_color);
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

        Button buttonSave = findViewById(R.id.add_clothing_saveItem);

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
                    //TODO: HERE
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

        buttonAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });

        buttonTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            previewImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            cursor.close();
            return;
        }
        else if(requestCode == CAMERA_PIC_REQUEST){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            previewImage.setImageBitmap(image);
            return;
        }
    }


}

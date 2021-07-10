package com.example.qwikcloset;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

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

        TextView moodPrompter = findViewById(R.id.add_clothing_mood_prompter);
        Button buttonSad = findViewById(R.id.add_clothing_sad);
        Button buttonConfident = findViewById(R.id.add_clothing_confident);
        Button buttonRelaxed = findViewById(R.id.add_clothing_relaxed);
        Button buttonHappy = findViewById(R.id.add_clothing_happy);
        Button buttonNoEmotion = findViewById(R.id.add_clothing_no_emotion);

        TextView temperaturePrompter = findViewById(R.id.add_clothing_temperature_prompter);
        Button buttonHot = findViewById(R.id.add_clothing_hot);
        Button buttonWarm = findViewById(R.id.add_clothing_warm);
        Button buttonTemperate = findViewById(R.id.add_clothing_temperate);
        Button buttonCold = findViewById(R.id.add_clothing_cold);
        Button buttonFreezing  = findViewById(R.id.add_clothing_freezing);
        Button buttonNoTemperature = findViewById(R.id.add_clothing_no_temperature);

        TextView precipitationPrompter = findViewById(R.id.add_clothing_precipitation_prompter);
        Button buttonClear = findViewById(R.id.add_clothing_clear);
        Button buttonCloudy = findViewById(R.id.add_clothing_cloudy);
        Button buttonRaining = findViewById(R.id.add_clothing_raining);
        Button buttonSnowing = findViewById(R.id.add_clothing_snowing);
        Button buttonnoPrecipitation = findViewById(R.id.add_clothing_no_precipitation);

        TextView taskPrompter = findViewById(R.id.add_clothing_task_prompter);
        Button buttonBusiness = findViewById(R.id.add_clothing_business);
        Button buttonLabor = findViewById(R.id.add_clothing_labor);
        Button buttonCasual = findViewById(R.id.add_clothing_casual);
        Button buttonParty = findViewById(R.id.add_clothing_party);
        Button buttonElegant = findViewById(R.id.add_clothing_elegant);
        Button buttonActive = findViewById(R.id.add_clothing_active);
        Button buttonNoTask = findViewById(R.id.add_clothing_no_task);

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
        Button buttonNocolor = findViewById(R.id.add_clothing_no_color);


    }
}

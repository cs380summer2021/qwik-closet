package com.example.qwikcloset;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OutfitGalleryView extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList, String callState){

        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(  this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(  this, allCategoryList, callState);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_scrollable_view);

        DatabaseHelper myDb = new DatabaseHelper(this);
        ArrayList<Outfit> outfits = myDb.readOutfitCursor(myDb.getAllData_Outfit(), this);

        List<AllCategory> allCategoryList = new ArrayList<>();
        for(int i = 0; i < outfits.size(); ++i){
            List<CategoryItem> tempList = new ArrayList<>();
            Outfit tempOutfit = outfits.get(i);
            for(int j = 0; j < tempOutfit.clothing.size(); ++j){
                ClothingItem tempClothing = tempOutfit.clothing.get(j);
                if(tempClothing == null){
                    continue;
                }
                tempList.add(new CategoryItem(new Integer(tempOutfit.id), tempClothing.picture));
            }
            if(tempList.size() > 0){
                String tempName = "Outfit #" + tempOutfit.id;
                allCategoryList.add(new AllCategory(tempName, tempList));
            }
        }

        if(allCategoryList.size() > 0){
            setMainCategoryRecycler(allCategoryList, "OutFitGalleryView");
        }
        else{
            TextView textView = findViewById(R.id.closet_my_closet_text_view);
            textView.setText("You have no outfits.");
        }

        findViewById(R.id.returnToMainMenu).setVisibility(View.GONE);
    }
}

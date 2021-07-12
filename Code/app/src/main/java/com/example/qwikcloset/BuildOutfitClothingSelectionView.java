package com.example.qwikcloset;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BuildOutfitClothingSelectionView extends AppCompatActivity {

    DatabaseHelper myDb;
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

        myDb = new DatabaseHelper(this);
        getIncomingIntent();

    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("id")){
            String s = getIntent().getStringExtra("id");
            ArrayList<ClothingItem> clothingItems = myDb.categoryFilterClothingRetrieval(s, this);
            ArrayList<CategoryItem> categoryItems = new ArrayList<>();
            for(int j = 0; j < clothingItems.size(); ++j){
                ClothingItem tempClothingItem = clothingItems.get(j);
                categoryItems.add(new CategoryItem(tempClothingItem.id, tempClothingItem.picture));
            }
            ArrayList<AllCategory> allCategoryList = new ArrayList<>();
            allCategoryList.add(new AllCategory("", categoryItems));
            setMainCategoryRecycler(allCategoryList, "BuildOutfitView");
        }
        else{
            TextView t = findViewById(R.id.closet_my_closet_text_view);
            t.setText("ERROR");
        }


    }
}

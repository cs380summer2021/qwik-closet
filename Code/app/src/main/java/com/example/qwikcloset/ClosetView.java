package com.example.qwikcloset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class ClosetView extends AppCompatActivity {
    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_scrollable_view);
        myDb = new DatabaseHelper(this);

        ArrayList<ClothingItem> clothing = myDb.getAllData_Clothing(this);


        List<CategoryItem> categoryItemList1 = new ArrayList<>();
        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        List<CategoryItem> categoryItemList4 = new ArrayList<>();

        for(int i = 0; i < clothing.size(); ++i){
            ClothingItem clothingItem = clothing.get(i);
            switch (clothingItem.category){
                case "1":
                    categoryItemList1.add(new CategoryItem(clothingItem.id, clothingItem.picture));
                    break;
                case "2":
                    categoryItemList2.add(new CategoryItem(clothingItem.id, clothingItem.picture));
                    break;
                case "3":
                    categoryItemList3.add(new CategoryItem(clothingItem.id, clothingItem.picture));
                    break;
                case "4":
                    categoryItemList4.add(new CategoryItem(clothingItem.id, clothingItem.picture));
                    break;
                default:
            }
        }


        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Tops", categoryItemList1));
        allCategoryList.add(new AllCategory("Bottoms", categoryItemList2));
        allCategoryList.add(new AllCategory("Shoes", categoryItemList3));
        allCategoryList.add(new AllCategory("Accessories", categoryItemList4));

        setMainCategoryRecycler(allCategoryList);

        Button buttonNavigateToStart = (Button) findViewById(R.id.returnToMainMenu);

        buttonNavigateToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ClosetView", "onClick: Clicked returnToMainMenu");

                Intent intent = new Intent(ClosetView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){

        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(  this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(  this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);


    }


}
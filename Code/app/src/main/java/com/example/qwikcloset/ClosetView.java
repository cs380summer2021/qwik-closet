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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_scrollable_view);

        //1st category
        List<CategoryItem> categoryItemList1 = new ArrayList<>();
        categoryItemList1.add(new CategoryItem(1, R.drawable.tops1));
        categoryItemList1.add(new CategoryItem(1, R.drawable.tops2));
        categoryItemList1.add(new CategoryItem(1, R.drawable.tops3));
        categoryItemList1.add(new CategoryItem(1, R.drawable.tops4));
        categoryItemList1.add(new CategoryItem(1, R.drawable.tops5));
        categoryItemList1.add(new CategoryItem(1, R.drawable.tops6));

        //2nd category
        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(1, R.drawable.bottoms1));
        categoryItemList2.add(new CategoryItem(1, R.drawable.bottoms2));
        categoryItemList2.add(new CategoryItem(1, R.drawable.bottoms3));
        categoryItemList2.add(new CategoryItem(1, R.drawable.bottoms4));
        categoryItemList2.add(new CategoryItem(1, R.drawable.bottoms5));
        categoryItemList2.add(new CategoryItem(1, R.drawable.bottoms6));

        //3rd category
        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(1, R.drawable.shoes1));
        categoryItemList3.add(new CategoryItem(1, R.drawable.shoes2));
        categoryItemList3.add(new CategoryItem(1, R.drawable.shoes3));
        categoryItemList3.add(new CategoryItem(1, R.drawable.shoes4));
        categoryItemList3.add(new CategoryItem(1, R.drawable.shoes5));
        categoryItemList3.add(new CategoryItem(1, R.drawable.shoes6));

        //4th category
        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        Integer four = R.drawable.accessories1;
        categoryItemList4.add(new CategoryItem(1, R.drawable.accessories1));
        categoryItemList4.add(new CategoryItem(1, R.drawable.accessories2));
        categoryItemList4.add(new CategoryItem(1, R.drawable.accessories3));
        categoryItemList4.add(new CategoryItem(1, R.drawable.accessories4));
        categoryItemList4.add(new CategoryItem(1, R.drawable.accessories5));
        categoryItemList4.add(new CategoryItem(1, R.drawable.accessories6));



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
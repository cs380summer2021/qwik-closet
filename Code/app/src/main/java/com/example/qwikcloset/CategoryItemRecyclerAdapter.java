package com.example.qwikcloset;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;

    public CategoryItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull

    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryItemRecyclerAdapter.CategoryItemViewHolder holder, int position) {
        holder.itemImage.setImageDrawable(categoryItemList.get(position).getImageUrl());
        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClothingItemView.class);
                int j = position;
                List<CategoryItem> list = categoryItemList;
                CategoryItem categoryItem = categoryItemList.get(position);
                intent.putExtra("id", categoryItemList.get(position).itemId.toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder{

        ImageButton itemImage;
        RelativeLayout parentLayout;
        Button button;

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}


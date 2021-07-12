package com.example.qwikcloset;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;
    private String callState;

    public CategoryItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList, String callState) {
        this.context = context;
        this.categoryItemList = categoryItemList;
        this.callState = callState;
    }

    @NonNull

    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryItemRecyclerAdapter.CategoryItemViewHolder holder, int position) {
        holder.itemImage.setImageDrawable(categoryItemList.get(position).getImage());

        switch (callState){
            case "ClosetView":
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
                break;
            case "BuildOutfitView":
                holder.itemImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("result", categoryItemList.get(position).itemId.toString());
                        Activity activity = (Activity) context;
                        if(activity.getIntent().hasExtra("slot")){
                            intent.putExtra("slot", activity.getIntent().getStringExtra("slot"));
                        }
                        activity.setResult(Activity.RESULT_OK, intent);
                        activity.finish();
                    }
                });
                break;
            case "OutFitGalleryView":
                holder.itemImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, OutfitView.class);
                        intent.putExtra("outfitId", categoryItemList.get(position).itemId.toString());
                        context.startActivity(intent);
                    }
                });
                break;
            default:
        }
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


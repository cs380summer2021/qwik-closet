package com.example.qwikcloset;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class CategoryItem {
    Integer itemId;
    Drawable drawable;

    public CategoryItem(Integer itemId, Drawable drawable) {
        this.itemId = itemId;
        this.drawable = drawable;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Drawable getImageUrl() {
        return drawable;
    }

    /*public void setImageUrl(Integer imageUrl) {
        this.drawable = imageUrl;
    }*/
}

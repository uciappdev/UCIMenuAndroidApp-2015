package com.example.edith.ucimenu.restaurantmodel;

import android.content.Context;

/**
 * Created by Andy on 5/22/2015.
 */
public class Restaurant {

    public String name;
    public String description;
    public String imageName;

    public int getImageResourceID(Context context) {
        try {
            return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
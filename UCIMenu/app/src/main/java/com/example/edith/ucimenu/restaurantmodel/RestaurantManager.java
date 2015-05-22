package com.example.edith.ucimenu.restaurantmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy on 5/22/2015.
 */
public class RestaurantManager {

    private static String[] restaurantArray = {"Lot 5", "Pippins", "Brandywine Commons", "Mesa Commons"};
    private static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut " +
            "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
            "commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private static RestaurantManager mInstance;
    private List<Restaurant> restaurants;

    public static RestaurantManager getInstance() {
        if (mInstance == null) {
            mInstance = new RestaurantManager();
        }

        return mInstance;
    }

    public List<Restaurant> getRestaurants() {
        if (restaurants == null) {
            restaurants = new ArrayList<Restaurant>();

            for (String restaurantName : restaurantArray) {
                Restaurant restaurant = new Restaurant();
                restaurant.name = restaurantName;
                restaurant.description = loremIpsum;
                restaurant.imageName = restaurantName.replaceAll("\\s+","").toLowerCase();
                restaurants.add(restaurant);
            }
        }

        return restaurants;
    }
}

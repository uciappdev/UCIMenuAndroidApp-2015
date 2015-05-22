package com.example.edith.ucimenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.edith.ucimenu.restaurantmodel.Restaurant;

import org.w3c.dom.Text;

/**
 * Created by Andy on 5/22/2015.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Restaurant> restaurants;
    private int cardLayout;
    private Context mContext;

    public MainAdapter(List<Restaurant> restaurants, int cardLayout, Context context) {
        this.restaurants = restaurants;
        this.cardLayout = cardLayout;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(cardLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Restaurant restaurant = restaurants.get(i);
        viewHolder.restaurantName.setText(restaurant.name);
        viewHolder.restaurantImage.setImageDrawable(mContext.getDrawable(restaurant.getImageResourceID(mContext)));
    }

    @Override
    public int getItemCount() {
        return restaurants == null ? 0 : restaurants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView restaurantName;
        public ImageView restaurantImage;

        public ViewHolder(View itemView) {
            super(itemView);
            restaurantName = (TextView)itemView.findViewById(R.id.restaurantName);
            restaurantImage = (ImageView)itemView.findViewById(R.id.restaurantImage);
        }
    }
}

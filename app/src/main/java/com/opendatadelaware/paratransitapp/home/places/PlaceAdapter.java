package com.opendatadelaware.paratransitapp.home.places;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.Place;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{

    ArrayList<Place> places;

    public PlaceAdapter(ArrayList<Place> places) {
        this.places = places;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_row_layout, parent, false);

        PlaceViewHolder viewHolder = new PlaceViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PlaceViewHolder placeViewHolder = (PlaceViewHolder) holder;

        Place currentPlace = places.get(position);

        placeViewHolder.placeName.setText(currentPlace.getName());

        placeViewHolder.placeAddress.setText(currentPlace.getAddress());


    }

    @Override
    public int getItemCount() {
        return places.size();
    }

}

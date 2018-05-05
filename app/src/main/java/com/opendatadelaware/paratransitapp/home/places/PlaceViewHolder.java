package com.opendatadelaware.paratransitapp.home.places;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import com.opendatadelaware.paratransitapp.R;


public class PlaceViewHolder extends PlaceBaseViewHolder {

    CardView cardView;
    TextView placeName;
    TextView placeAddress;

    public PlaceViewHolder(View view) {
        super(view);

        cardView = view.findViewById(R.id.placeCardView);
        placeName = view.findViewById(R.id.placeNameView);
        placeAddress = view.findViewById(R.id.placeAddress);
    }


}




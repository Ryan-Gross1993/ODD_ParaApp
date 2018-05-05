package com.opendatadelaware.paratransitapp.home.reservations;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.opendatadelaware.paratransitapp.R;

public class ReservationViewHolder extends BaseViewHolder {

    CardView cardView;
    TextView textView;
    TextView reservationTimeView;

    public ReservationViewHolder(View view) {
        super(view);
        cardView = view.findViewById(R.id.testCardView);
        textView = view.findViewById(R.id.titleView);
        reservationTimeView = view.findViewById(R.id.reservationTimeTextView);
    }

}

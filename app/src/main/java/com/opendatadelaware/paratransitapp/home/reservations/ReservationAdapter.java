package com.opendatadelaware.paratransitapp.home.reservations;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.Reservation;

import java.util.ArrayList;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ViewHolder> {

    ArrayList<Reservation> reservations;

    public ReservationAdapter(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_layout,
                parent, false);

        ReservationViewHolder reservationViewHolder = new ReservationViewHolder(view);

        return reservationViewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ReservationViewHolder reservationViewHolder = (ReservationViewHolder) holder;

        Reservation currentReservation = reservations.get(position);

        reservationViewHolder.textView.setText(currentReservation.getTitle());

        reservationViewHolder.reservationTimeView.setText(currentReservation.getReservationTime());

    }

    @Override
    public int getItemCount() {
        return reservations.size();
    }
}


package com.opendatadelaware.paratransitapp.home.reservations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.Reservation;
import com.opendatadelaware.paratransitapp.util.FieldGenerator;

import java.util.ArrayList;

public class ReservationsListFragment extends Fragment {

    View reservationsListView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    FloatingActionButton addReservationButton;
    FieldGenerator fieldGenerator;

    ArrayList<Reservation> reservations = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fieldGenerator = new FieldGenerator();

        reservations = fieldGenerator.generateListOfReservations();

        reservationsListView = inflater.inflate(R.layout.activity_recycler, container, false);

        recyclerView = reservationsListView.findViewById(R.id.recyclerView);

        addReservationButton = reservationsListView.findViewById(R.id.addReservationButton);

        addReservationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                moveToAddReservationFragment();
            }

        });

        return reservationsListView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new ReservationAdapter(reservations);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void moveToAddReservationFragment() {

        Intent addReservationIntent = new Intent(getActivity(), AddReservationsActivity.class);
        startActivity(addReservationIntent);
    }
}

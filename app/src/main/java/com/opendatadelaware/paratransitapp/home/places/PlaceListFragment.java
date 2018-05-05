package com.opendatadelaware.paratransitapp.home.places;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.Place;
import com.opendatadelaware.paratransitapp.util.FieldGenerator;

import java.util.ArrayList;

public class PlaceListFragment extends Fragment {

    View placeListView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    ArrayList<Place> places = new ArrayList<>();
    FieldGenerator generator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        placeListView = inflater.inflate(R.layout.activity_recycler_placelist, container, false);

        generator = new FieldGenerator();

        recyclerView = placeListView.findViewById(R.id.recyclerView);

        return placeListView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new PlaceAdapter(places);

        recyclerView.setAdapter(recyclerViewAdapter);
    }

}

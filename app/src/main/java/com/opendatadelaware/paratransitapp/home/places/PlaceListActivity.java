package com.opendatadelaware.paratransitapp.home.places;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.model.Place;
import com.opendatadelaware.paratransitapp.util.FieldGenerator;

import java.util.ArrayList;

public class PlaceListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    ArrayList<Place> places = new ArrayList<>();
    FieldGenerator generator = new FieldGenerator();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String type = getIntent().getStringExtra("TYPE");

        if (type.equals("RESOURCES")) {

            places = generator.generateLibraries();

        } else if (type.equals("MEDICAL")) {

            places = generator.generateHospitals();

        }


        setContentView(R.layout.activity_place_list);

        recyclerView = findViewById(R.id.placeRecyclerView);

        recyclerViewLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new PlaceAdapter(places);

        recyclerView.setAdapter(recyclerViewAdapter);
    }

}

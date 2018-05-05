package com.opendatadelaware.paratransitapp.home.places;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.userregistration.RegistrationActivity;

public class PlaceCategoryFragment extends Fragment {

    View placeCategoryView;
    CardView medicalCardView;
    CardView resourcesCardView;
    CardView entertainmentCardView;
    CardView parksCardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        placeCategoryView = inflater.inflate(R.layout.fragment_categories, container, false);

        medicalCardView = placeCategoryView.findViewById(R.id.medicalCardView);
        resourcesCardView = placeCategoryView.findViewById(R.id.resourcesCardView);
        entertainmentCardView = placeCategoryView.findViewById(R.id.entertainmentCardView);
        parksCardView = placeCategoryView.findViewById(R.id.parksCardView);

        medicalCardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                setListenerIntent(view);

            }
        });

        resourcesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setListenerIntent(view);

            }
        });

        entertainmentCardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setListenerIntent(view);
            }
        });

        parksCardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setListenerIntent(view);
            }

        });

        return placeCategoryView;

    }


    public void setListenerIntent(View view) {


        String intentValue = getIntentValue(view);
        Intent placeListIntent = new Intent(getActivity(), PlaceListActivity.class);
        placeListIntent.putExtra("TYPE", intentValue);
        startActivity(placeListIntent);

    }

    public String getIntentValue(View view) {

        switch (view.getId()) {

            case R.id.medicalCardView:
                return "MEDICAL";
            case R.id.entertainmentCardView:
                return "ENTERTAINMENT";
            case R.id.parksCardView:
                return "PARKS";
            default:
                return "RESOURCES";
        }

    }
}





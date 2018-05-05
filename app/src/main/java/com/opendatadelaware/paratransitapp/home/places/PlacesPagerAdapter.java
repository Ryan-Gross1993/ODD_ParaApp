package com.opendatadelaware.paratransitapp.home.places;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.opendatadelaware.paratransitapp.home.reservations.ReservationsListFragment;

public class PlacesPagerAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;

    public PlacesPagerAdapter(FragmentManager fragmentManager, int numberOfTabs) {
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("GetItem", "Was called for Position" + String.valueOf(position));
        switch (position) {

            case 0:
                return new PlaceCategoryFragment();
            case 1:
                PlaceListFragment allPlacesFragment = new PlaceListFragment();
                Bundle allPlacesBundle = new Bundle();
                allPlacesBundle.putString("TYPE", "ALL");
                allPlacesFragment.setArguments(allPlacesBundle);
                return allPlacesFragment;

            case 2:
                PlaceListFragment favoritePlacesFragment = new PlaceListFragment();
                Bundle favoritePlacesBundle = new Bundle();
                favoritePlacesBundle.putString("TYPE", "FAVORITES");
                favoritePlacesFragment.setArguments(favoritePlacesBundle);
                return favoritePlacesFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}

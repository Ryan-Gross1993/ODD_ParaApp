package com.opendatadelaware.paratransitapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.opendatadelaware.paratransitapp.R;
import com.opendatadelaware.paratransitapp.home.places.PlacesActivity;
import com.opendatadelaware.paratransitapp.home.reservations.ReservationsListFragment;
import com.opendatadelaware.paratransitapp.home.userprofile.UserProfileFragment;
import com.opendatadelaware.paratransitapp.model.Reservation;
import com.opendatadelaware.paratransitapp.model.User;
import com.opendatadelaware.paratransitapp.util.FieldGenerator;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    User applicantUser;
    static FieldGenerator generator = new FieldGenerator();
    ArrayList<Reservation> reservationsFromAddedActivity;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        if (getIntent().hasExtra("user")) {

            applicantUser = (User) getIntent().getSerializableExtra("user");

        } else {

            applicantUser = generator.generateGenericUser();

        }


        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                switch (menuItem.getItemId()) {

                    case R.id.action_profile:
                        UserProfileFragment userProfileFragment = new UserProfileFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", applicantUser);
                        userProfileFragment.setArguments(bundle);
                        menuItem.setChecked(true);
                        fragmentTransaction.replace(R.id.mainMenuContainer, userProfileFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;

                    case R.id.action_rides:
                        ReservationsListFragment listFragment = new ReservationsListFragment();
                        if (getIntent().hasExtra("reservations")) {
                            ArrayList<Reservation> reservations = (ArrayList<Reservation>) getIntent().getSerializableExtra("reservations");
                            Bundle listBundle = new Bundle();
                            listBundle.putSerializable("reservations", reservations);
                            listFragment.setArguments(listBundle);
                        }
                            menuItem.setChecked(true);
                            fragmentTransaction.replace(R.id.mainMenuContainer, listFragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                            break;

                            case R.id.action_places:
                                Intent placesIntent = new Intent(getApplicationContext(), PlacesActivity.class);
                                startActivity(placesIntent);
                                break;

                        }
                        return true;
                }
            });

            Toolbar toolbar = findViewById(R.id.toolbar);

            setSupportActionBar(toolbar);
        toolbar.setTitle("ParaApp");

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainMenuContainer,new

            UserProfileFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.toolbar_menu, menu);

            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem menuItem){

            switch (menuItem.getItemId()) {

                case R.id.action_logout:
                    return true;
                default:
                    return super.onOptionsItemSelected(menuItem);
            }

        }

    }

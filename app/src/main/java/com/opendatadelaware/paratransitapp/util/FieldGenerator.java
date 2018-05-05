package com.opendatadelaware.paratransitapp.util;

import com.opendatadelaware.paratransitapp.model.Gender;
import com.opendatadelaware.paratransitapp.model.Place;
import com.opendatadelaware.paratransitapp.model.Reservation;
import com.opendatadelaware.paratransitapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class FieldGenerator {

    public User generateGenericUser() {

        User user = new User("New User", "MyEmail@email.com", "SuperSafePassword", Gender.FEMALE);

        return user;

    }

    public ArrayList<Reservation> generateListOfReservations() {

        ArrayList<Reservation> reservations = new ArrayList<>();

        Reservation one = new Reservation("Trip to Walmart", "8:00 AM on 5/9/18");
        Reservation two = new Reservation("Doctor's Apt", "5/10/18 at 5:30 PM");
        Reservation three = new Reservation("Birthday Dinner", "5/11/18 at 4:30 PM");
        Reservation four = new Reservation("Bingo Night", "7:30 PM at 5/15/18");
        Reservation five = new Reservation("Park w/ Grandson", "2:50PM on 5/19/18");
        reservations.add(one);
        reservations.add(two);
        reservations.add(three);
        reservations.add(four);
        reservations.add(four);
        reservations.add(five);

        return reservations;
    }

    public ArrayList<Place> generateLibraries() {

        ArrayList<Place> places = new ArrayList<>();

        Place place = new Place("Bear Public Library", "101 Governors Place, Bear, DE 19701");
        Place placeTwo = new Place("Kirkwood Library", "6000 Kirkwood Hwy, Wilmington, DE 19808");
        Place placeThree = new Place("New Castle Public Library", "121 Union St, New Castle, 19720");
        Place placeFour = new Place("Elsmere Public Libarary", "30 Spruce Ave, Wilmington, DE 19805");
        places.add(place);
        places.add(placeTwo);
        places.add(placeThree);
        places.add(placeFour);

        return places;

    }

    public ArrayList<Place> generateHospitals() {

        ArrayList<Place> hospitals = new ArrayList<>();

        Place place = new Place("Wilmington Hospital", "1601 Kirkwood Hwy, Wilmington, DE 19801");
        Place placeTwo = new Place("Wilmington VA", "1601 Kirkwood Hwy, Wilmington, DE 19805");
        Place placeThree = new Place("Rockford", "100 Rockford Dr, Newark, DE 19713");
        Place placeFour = new Place("St Francis", "701 N Clayton St, Wilmington DE, 19805");
        hospitals.add(place);
        hospitals.add(placeTwo);
        hospitals.add(placeThree);
        hospitals.add(placeFour);

        return hospitals;

    }

    public ArrayList<Place> generateAll() {

        ArrayList<Place> all = new ArrayList<>();

        for (Place hospital : generateHospitals()) {

            all.add(hospital);
        }

        for (Place library : generateLibraries()) {

            all.add(library);

        }

        return all;


    }



}

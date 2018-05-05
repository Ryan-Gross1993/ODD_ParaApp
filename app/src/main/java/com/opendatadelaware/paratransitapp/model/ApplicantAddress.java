package com.opendatadelaware.paratransitapp.model;

import java.io.Serializable;

public class ApplicantAddress implements Serializable{

    private String streetAddress;
    private String state;
    private String zipCode;


    public ApplicantAddress(String address, String state, String zipCode) {

        this.streetAddress = address;
        this.state = state;
        this.zipCode = zipCode;

    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }


    @Override
    public String toString() {

        return streetAddress + " " + "," + state + zipCode;

    }

}

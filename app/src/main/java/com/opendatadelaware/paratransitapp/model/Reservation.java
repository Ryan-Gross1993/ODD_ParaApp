package com.opendatadelaware.paratransitapp.model;

public class Reservation {

    private String title;
    private String reservationTime;
    private String pickupDestination;
    private String dropoffDestination;

    public Reservation() {}

    public Reservation(String title, String reservationTime) {
        this.title = title;
        this.reservationTime = reservationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getPickupDestination() {
        return pickupDestination;
    }

    public void setPickupDestination(String pickupDestination) {
        this.pickupDestination = pickupDestination;
    }

    public String getDropoffDestination() {
        return dropoffDestination;
    }

    public void setDropoffDestination(String dropoffDestination) {
        this.dropoffDestination = dropoffDestination;
    }
}

package com.hi.d.throbo.Model;

public class Booking {
    private Trip trip;
    private Customer customer;
    private int seatNum;

    public Trip getTrip() {
        return this.trip;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public int getSeat() {
        return this.seatNum;
    }
}

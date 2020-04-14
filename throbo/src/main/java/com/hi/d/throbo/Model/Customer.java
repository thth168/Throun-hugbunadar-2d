package com.hi.d.throbo.Model;

public class Customer extends Users {
    private Bookings[] bookings;
    private Reviews[] reviews;

    public Bookings[] getbookings() {
        return bookings;
    }

    public Reviews[] getReviews() {
        return reviews;
    }
}

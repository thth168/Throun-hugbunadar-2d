package com.hi.d.throbo.Model;

public class Customer extends User {
    private Booking[] bookings;
    private Reviews[] reviews;

    public Booking[] getBookings() {
        return bookings;
    }

    public Reviews[] getReviews() {
        return reviews;
    }
}

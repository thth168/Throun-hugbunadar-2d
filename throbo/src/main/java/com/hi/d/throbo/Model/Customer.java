package com.hi.d.throbo.Model;

public class Customer extends User {
    private Booking[] bookings;
    private Reviews[] reviews;

    public Booking[] getBookings() {
        return this.bookings;
    }

    public Reviews[] getReviews() {
        return this.reviews;
    }
}

package com.hi.d.throbo.Model;

public class Review {
    private Trip trip;
    private String review;
    private Customer reviewer;
    private int rating;

    public Trip getTrip() {
        return trip;
    }

    public String getReview() {
        return review;
    }

    public Customer getReviewer() {
        return reviewer;
    }

    public int getRating() {
        return rating;
    }
}

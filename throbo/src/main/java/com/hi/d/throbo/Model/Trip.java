package com.hi.d.throbo.Model;

import java.sql.Date;

public class Trip {
    private double rating;
    private Review[] reviews;
    private int price;
    private boolean availability;
    private String[] tags;
    private Date date;
    private Agency agency;

    public double getRating() {
        return this.rating;
    }

    public Reviews[] getReviews() {
        return this.reviews;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean getAvailibility() {
        return this.availability;
    }

    public String[] getTags() {
        return this.tags;
    }

    public Date getDate() {
        return this.date;
    }

    public Agency getAgency() {
        return this.agency;
    }
}

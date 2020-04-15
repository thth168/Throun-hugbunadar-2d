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
        return rating;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public int getPrice() {
        return price;
    }

    public boolean getAvailibility() {
        return availability;
    }

    public String[] getTags() {
        return tags;
    }

    public Date getDate() {
        return date;
    }

    public Agency getAgency() {
        return agency;
    }
}

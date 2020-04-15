package com.hi.d.throbo.Model;

import com.hi.d.throbo.Database.Database;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Trip {
    private String name;
    private int stars;
    private ArrayList<Review> reviews;
    private int price;
    private boolean availability;
    private String[] tags;
    private Date date;
    private Agency agency;

    public Trip(ResultSet rs) throws ClassNotFoundException, SQLException {
        Database db = Database.getInstance();
        name = rs.getString("name");
        stars = rs.getInt("stars");
        reviews = new ArrayList();
        ResultSet reviewSet = db.search("SELECT * FROM review WHERE trip_id = " + rs.getInt("id"));
        while(reviewSet != null){
            reviews.add(new Review());
            reviewSet.next();
        }
        price = rs.getInt("price");
        availability = rs.getBoolean("available");
        date = rs.getDate("date");
        int agency_id = rs.getInt("agency_id");
        ResultSet agencySet = db.search("SELECT * FROM users WHERE id = " + agency_id);
        agency = new Agency(agencySet);
    }
    
    public double getRating() {
        return stars;
    }

    public String[] getReviews() {
        ArrayList<String> review = new ArrayList();
        for(Review r : reviews){
            String temp = "";
            temp += r.getReviewer().getName() + "\n";
            temp += r.getReview() + "\n";
            review.add(temp);
        }
        return (String[]) review.toArray();
    }

    public String getName() {
        return name;
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

    public String getAgency() {
        return agency.getName();
    }
}

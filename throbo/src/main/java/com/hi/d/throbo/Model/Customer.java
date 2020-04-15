package com.hi.d.throbo.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends User {
    private Booking[] bookings;
    private Review[] reviews;
    
    public Customer(ResultSet rs) throws SQLException{
        super(rs);
    }

    public String getBookings() {
        return "Bookings";
    }

    public String getReviews() {
        return "Review";
    }
}

package com.hi.d.throbo.Model;

import com.hi.d.throbo.Database.Database;
import java.sql.ResultSet;

public class Booking {
    private Trip trip;
    private Customer customer;
    private int seatNum;

    public Booking(ResultSet rs) throws ClassNotFoundException{
        Database db = Database.getInstance();
        trip = new Trip();
    }
    
    public String getTrip() {
        return trip.getName();
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getSeat() {
        return seatNum;
    }
}

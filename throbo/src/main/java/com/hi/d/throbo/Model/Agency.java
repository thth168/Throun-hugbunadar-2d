package com.hi.d.throbo.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Agency extends User {
    private Trip[] trips;
    
    public Agency(ResultSet rs) throws SQLException{
        super(rs);
    }
    
    public String getTrips() {
        return "Trips";
    }
}

package com.hi.d.throbo.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class User {
    private final String username;
    private final String name;
    
    public User(ResultSet rs) throws SQLException{
        username = rs.getString("username");
        name = rs.getString("firstName") + " " + rs.getString("lastName");
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }
}

package com.hi.d.throbo.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hi.d.throbo.Database.Database;

public class Users {
    private static Database db;

    public Users () {
        try {
            db = Database.getInstance();
        } catch(ClassNotFoundException e){
            System.err.print(e);
        }
    }

    public String getUser(String name) throws ClassNotFoundException {
        try {
            if(!name.contains(" ")) {
                ResultSet rs = db.search("SELECT name FROM users WHERE name="+name);
                if(rs.next()) {
                    return rs.getString("firstName");
                } else {
                    return "";
                }
            } else {
                return "Invalid Query";
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return "";
        }
    }
    
    public void searchAll() throws ClassNotFoundException {
        db.searchQuery("SELECT * FROM users");
    }
    public void searchAgency() throws ClassNotFoundException {

    }
    public void searchCustomer(String param) throws ClassNotFoundException {
        db.searchQuery(param);
    }
}
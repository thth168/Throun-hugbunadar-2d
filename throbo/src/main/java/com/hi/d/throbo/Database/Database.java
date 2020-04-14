package com.hi.d.throbo.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Database single_instance = null;
    private static Connection conn;
    private static Statement stmt;

    private Database () throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:DayTriper.sqlite");
            stmt = conn.createStatement();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static Database getInstance() throws ClassNotFoundException{
        if(single_instance == null) {
            single_instance = new Database();
        }
        return single_instance;
    }
    
    public ResultSet search(String param) throws ClassNotFoundException {
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(param);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void searchQuery(String param) throws ClassNotFoundException{
        try {
            ResultSet rs = search(param);
            while(rs.next())
            {
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("firstName = " + rs.getString("firstName"));
                System.out.println("lastName = "+ rs.getString("lastName"));
                System.out.println("gender = "+ rs.getString("gender"));
                System.out.println("age = "+ rs.getInt("age"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void close() {
        try {
            if(!conn.isClosed()){
                conn.close();
            }
        } catch(SQLException e) {
            System.err.println(e);
        }
    }
}
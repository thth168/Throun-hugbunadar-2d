package com.hi.d.throbo.Controller;

import com.hi.d.throbo.Database.Database;
import java.util.Date;
// connection to db and imports still needed

public class SearchController{
    public static Database db;
    public String tourCategory;
    public int tourPrice;
    public int numOfSeatsLeft;
    public Date tourDate;
    public double[] tourLocation; // not sure if this is the 100% right way with the import above
    public double[] tourPickUp;
    public String linkedTours; // don´t know if this is how we can search for linked tours
    public String groupSeatingOnTour; // ??? don't know if we want this here
    public String uniqueEvents; // do we want this here
    public int tourRating;
}
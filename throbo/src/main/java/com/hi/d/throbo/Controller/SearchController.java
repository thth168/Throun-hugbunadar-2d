package com.hi.d.throbo.Controller;

import com.hi.d.throbo.Database.Database;
import java.util.Date;
// connection to db and imports still needed

public class SearchController{
    private Database db;
    private String tourCategory; // √
    private int tourPrice; // √
    private int numOfSeatsLeft; //√
    private Date tourDate; //√
    private String linkedTours; // don´t know if this is how we can search for linked tours
    private String groupSeatingOnTour; // ??? don't know if we want this here
    private String uniqueEvents; // do we want this here
    private int tourRating; //√
    
    public SearchController() throws ClassNotFoundException{
        try {
            db = Database.getInstance();
        } catch(ClassNotFoundException e) {
            System.err.println(e);
        }
    }

    //get and set for tour prices
    public int getTourPrice(){
        return tourPrice;
    }

    public void setTourPrice(){
        SearchController searchController = this;
        searchController.tourPrice = tourPrice;
    }

    // get and set tour category
    public String getTourCat(){
        return tourCategory;
    }
    public void setTourCat(){
        SearchController searchController = this;
        searchController.tourCategory = tourCategory;
    }

    //get and set tour date
    public Date getTourDate(){
        return tourDate;
    }

    public void setTourDate(Date _tourDate){
        this.tourDate = tourDate;
    }

    //get and set number of seats left

    public int getNumOfSeatsLeft(){
        return numOfSeatsLeft;
    }

    public void setNumOfSeatsLeft(){
        this.numOfSeatsLeft = numOfSeatsLeft;
    }

    //get and set tour rating
    public int getTourRating(){
        return tourRating;
    }

    public void setTourRating(){
        this.tourRating = tourRating;
    }
}
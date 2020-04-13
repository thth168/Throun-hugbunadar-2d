import java.util.Date;

import javax.xml.stream.Location;


// connection to db and imports still needed

public class SearchController{
    public static Database db = new Database();
    public String tourCategory; // √
    public int tourPrice; // √
    public int numOfSeatsLeft; //√
    public Date tourDate; //√
    public String linkedTours; // don´t know if this is how we can search for linked tours
    public String groupSeatingOnTour; // ??? don't know if we want this here
    public String uniqueEvents; // do we want this here
    public int tourRating; //√
    

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
        searchController.tourCategorye = tourCategory;
    }

    //get and set tour date
    public Date getTourDate(){
        return tourDate;
    }

    public void setTourDate(){
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
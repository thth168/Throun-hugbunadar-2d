import javax.xml.stream.Location;

import javafx.event.ActionEvent;
import sun.applet.Main;


// connection to db and imports still needed

public class SearchController{
    public static Database db = new Database();
    public String tourCategory;
    public int tourPrice;
    public int numOfSeatsLeft;
    public Date tourDate;
    public Location tourLocation; // not sure if this is the 100% right way with the import above
    public Location tourPickUp;
    public String linkedTours; // don´t know if this is how we can search for linked tours
    public String groupSeatingOnTour; // ??? don't know if we want this here
    public String uniqueEvents; // do we want this here
    public int tourRating;
}
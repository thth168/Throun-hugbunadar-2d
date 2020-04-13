// need to connect to a database, but I do not know how..
// and then we need to import from there
public class TourController{
    public static Database db = new Database();
    /**
     * number if trips that are in the db
     */
    public int numOfTrips;
    /**
     * info about linked tours... don´t know if right
     * hehehe
     */
    public String linkedTours;

    // getting and setting the number of trips that are in the db
    public int getNumOfTrips(){
        return numOfTrips;
    }
    public void setNumOfTrips(int numOfTrips){
        this.numOfTrips = numOfTrips;
    }

    // still have no Idea of how to link tours together



}

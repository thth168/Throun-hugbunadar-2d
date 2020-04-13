public class Trips {
    private boolean available;
    private double rating;
    private Date date; 
    private int price;
    private Tag[] tags;
    private Agency agency;
    public boolean getAvailable(Trip trip) {
        if(trip) {
            return true;
        }
        return false;
    }
    public double getRating() {
        return rating;
    } 
    public int getPrice() {
        return price;
    }
    public Date getDate() {
        return date;
    }
    public void setPrice(int nPrice) {
        price = nPrice;
    }
    public Tag getTag() {
        return tags;
    }
    public void setTag(String ntag) {
        tags.add(ntag);
    }
    public Agency getAgency() {
        return agency;
    }
}
public class Reviews {
    private Trips trip;
    private Customer writer;
    private String review;
    private int rating;
    public Trip getTrip() {
        return trip;
    }
    public void setTrip(Trip currentTrip) {
        trip = currentTrip;
    }
    public Customer getWriter() {
        return writer;
    }
    public void setWriter(Customer it) {
        writer = it; 
    }
    public String getReviewText() {
        return review;
    }
    public int getReviewRating() {
        return rating;
    }
    public void setReview(String text, int setRating) {
        rating = setRating;
        review = text;
        system.err.println("review has been set");
    }
}
public class Review {
    private Trip trip;
    private String review;
    private Customer reviewer;
    private int rating;

    public Trip getTrip() {
        return this.trip;
    }

    public String getReview() {
        return this.review;
    }

    public Customer getReviewer() {
        return this.reviewer;
    }

    public int getRating() {
        return this.rating;
    }
}

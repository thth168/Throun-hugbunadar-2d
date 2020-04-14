public class Customer extends User {
    private Booking[] bookings;
    private Reviews[] reviews;

    public Booking[] getbookings() {
        return this.bookings;
    }

    public Reviews[] getReviews() {
        return this.reviews;
    }
}

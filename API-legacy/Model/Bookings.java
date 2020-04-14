public class Bookings {
    private Trip trip;
    private Customer customer;
    private int seatNr;
    public Trip getTrip() {
        return trip;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getSeat() {
        return seatNr;
    }
    public void changeSeat(int cSeat) {
        seatNr = cSeat;
    }
}
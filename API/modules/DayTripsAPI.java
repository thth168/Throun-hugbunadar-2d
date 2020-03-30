public class DayTripsAPI {
    private static Database db;
    private static Users users;

    public static void main(String[] args) throws ClassNotFoundException {
        db = new Database();
        users = new Users(db);
        users.search();
    }
}
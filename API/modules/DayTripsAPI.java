public class DayTripsAPI {

    private static Database db = new Database();
    private static Users users = new Users(db);

    public static void main(String[] args) throws ClassNotFoundException {
        users.search();
    }

}
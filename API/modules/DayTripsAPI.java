import java.util.Scanner;

public class DayTripsAPI {
    private static Database db;
    private static Users users;
    
    public static void main(String[] args) throws ClassNotFoundException {
        db = new Database();
        users = new Users(db);
        //users.searchAll();
        System.out.println("Search User");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        users.searchCustomer("SELECT * FROM users WHERE firstName = '"+name+"'");
    }
}
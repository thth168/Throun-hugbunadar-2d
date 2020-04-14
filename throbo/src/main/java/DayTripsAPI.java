import java.util.Scanner;
import com.hi.d.throbo.Database.Database;
import com.hi.d.throbo.Model.Users;

public class DayTripsAPI {
    private static Database db;
    private static Users users;
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            db = Database.getInstance();
            users = new Users();
            System.out.println("Search User");
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            users.searchCustomer("SELECT * FROM users WHERE firstName LIKE '"+name+"'");
            //users.searchAll();
        } catch(ClassNotFoundException e) {
            System.err.print(e.toString());
        }
        db.close();
    }
}
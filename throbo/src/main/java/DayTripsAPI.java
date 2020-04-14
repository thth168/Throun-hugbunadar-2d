import java.util.Scanner;
import java.sql.ResultSet;
import com.hi.d.throbo.Database.Database;
import com.hi.d.throbo.Model.Agency;
import com.hi.d.throbo.Model.Customer;
import com.hi.d.throbo.Model.WebMaster;
import java.sql.SQLException;

public class DayTripsAPI {
    private static Database db;
    private static Scanner s;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        s = new Scanner(System.in);
        try {
            db = Database.getInstance();
        } catch(ClassNotFoundException e) {
            System.err.print(e.toString());
        }
        
        // byðja um username
        System.out.println("Type in username:");
        String username = s.next();
        // byðja um password
        System.out.println("Type in password:");
        String password = s.next();
        
        ResultSet rs = db.search("SELECT * FROM users WHERE username = '" + username + "';");
        if(!rs.getString("password").equals(password)){
            db.close();
            System.out.println("Invalid credentials!!!");
            return;
        }
        System.out.println("Welcome back " + rs.getString("firstName"));
        System.out.println("To exit type \"exit\", for help type \"help\"");
        switch(rs.getInt("userType_id")) {
            case 1:
                webMasterHandler(new WebMaster(rs));
                break;
            case 2:
                agencyHandler(new Agency(rs));
                break;
            default:
                customerHandler(new Customer(rs));
                break;
        }
        db.close();
        System.out.println("Thank you, come again zoon.");
    }
    
    public static void webMasterHandler(WebMaster w) {
        String input = s.next();
        while(!input.equals("exit")){
            switch(input){
                case "help":
                    System.out.println("\n\"exit\": exit out of the program\n"
                            + "\"help\": displays this message\n"
                            + ""
                            + "");
                    break;
                default:
                    System.out.println("Invalid input, type \"help\" for help");
                    break;
            }
            System.out.print("Awaiting next input: ");            
            input = s.next();
        }
    }
    
    public static void agencyHandler(Agency a) {
        String input = s.next();
        while(!input.equals("exit")){
            switch(input){
                case "help":
                    System.out.println("\n\"exit\": exit out of the program\n"
                            + "\"help\": displays this message\n"
                            + "\"trips\": displays all the awailable trips\n"
                            + "");
                    break;
                case "trips":
                    System.out.println(a.getTrips());
                    break;
                default:
                    System.out.println("Invalid input, type \"help\" for help");
                    break;
            }
            System.out.print("Awaiting next input: ");            
            input = s.next();
        }
    }
    
    public static void customerHandler(Customer c) {
        String input = s.next();
        while(!input.equals("exit")){
            switch(input){
                case "help":
                    System.out.println("\n\"exit\": exit out of the program\n"
                            + "\"help\": displays this message\n"
                            + "\"bookings\": displays all active bookings\n"
                            + "\"reviews\": displays all past reviews\n");
                    break;
                case "bookings":
                    System.out.println(c.getBookings());
                    break;
                case "reviews":
                    System.out.println(c.getReviews());
                    break;
                default:
                    System.out.println("Invalid input, type \"help\" for help");
                    break;
            }
            System.out.print("Awaiting next input: ");
            input = s.next();
        }
    }
}
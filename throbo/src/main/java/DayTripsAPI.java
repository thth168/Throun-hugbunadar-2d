import java.util.Scanner;
import java.sql.ResultSet;
import com.hi.d.throbo.Database.Database;
import com.hi.d.throbo.Model.User;
import java.sql.SQLException;

public class DayTripsAPI {
    private static Database db;
    private static User users;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner s = new Scanner(System.in);
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
        db.close();
    }
}
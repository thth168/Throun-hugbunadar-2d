import java.util.Scanner;
import db.Database;

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
        users.searchAll();
    }
        // erum með tvær breytur, db og users
        @Before
        public void setUp(){
            System.out.println("@Before setup");
            if(user == null){
                user = new User(db);
            }
            
            
        }
    
        @After
        public void tearDown(){
            user = null;
    
        }
    
        @Test 
        public void testingSearch(){
            // ...
            assertEquals(user);
        }
}
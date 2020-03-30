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
        users.searchAll();
    }
        // erum með tvær breytur, db og users
        @Before
        public void setUp(){
            System.out.println("@Before setup");
            // viljum hafa lykkjum sem fer í gegnum ef að strengurinn fyrir name er == null
            // ef að hann er null þá getum við farið í það að uppfæra static breyturnar í það
            // sem hefur verið að leita að 
            if(user == null){
                user = new User(db);
            }
            
            
        }
    
        @After
        public void tearDown(){
            // núllstillum aftur gildin sem að var verið að vinna með 
           
            
    
        }
    
        @Test 
        public void testingSearch(){
            ...
            //vantar hérna hvað við verðum með, s.s hvort það sé array eða ehv annað
            assertEquals("gildin okkar koma hérna inn"); // mun gefa upp hvort að testið virkar eða ekki 
        }
}
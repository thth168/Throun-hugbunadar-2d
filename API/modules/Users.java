public class Users {

    private Database db;
    private String[] users;
    
    public Users (Database database) {
        db = database;
    }
    
    public search() {
        System.out.println(
            db.query(
                "SELECT * FROM Users"
            )
        );
    }

}

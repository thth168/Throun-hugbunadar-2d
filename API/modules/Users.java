public class Users {

    private Database db;
    
    public Users (Database database) {
        db = database;
    }
    
    public void search() throws ClassNotFoundException {
        db.initDatabase();
        db.searchQuery("SELECT * FROM users");
    }

}

public class Users {
    private static Database db;

    public Users (Database database) {
        db = database;
    }
    
    public void search() throws ClassNotFoundException {
        db.searchQuery("SELECT * FROM users");
    }
}
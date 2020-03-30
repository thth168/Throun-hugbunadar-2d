public class Users {
    private static Database db;

    public Users (Database database) {
        db = database;
    }
    
    public void searchAll() throws ClassNotFoundException {
        db.searchQuery("SELECT * FROM users");
    }
    public void searchAgency() throws ClassNotFoundException {

    }
    public void searchCustomer(String param) throws ClassNotFoundException {
        db.searchQuery(param);
    }
}
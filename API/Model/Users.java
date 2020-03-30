import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
    private static Database db;

    public Users (Database database) {
        db = database;
    }

    public String getUser(String name) throws ClassNotFoundException {
        try {
            if(!name.contains(" ")) {
                ResultSet rs = db.search("SELECT name FROM users WHERE name="+name);
                if(rs.next()) {
                    return rs.getString("firstName");
                } else {
                    return "";
                }
            } else {
                return "Invalid Query";
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return "";
        }
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
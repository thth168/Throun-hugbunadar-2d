import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection conn;

    public Database() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:DayTripper.db");
        }
        catch(SQLException error) {
            System.err.println(error.getMessage());
        }
    }

    public ResultSet search(String query) throws ClassNotFoundException {
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(query);
        }
        catch(SQLException error) {
            System.err.println(error.getMessage());
            return null;
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Database {
    private Connection conn;
    private Statement stmt;

    public void searchQuery(String param) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while(rs.next())
            {
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("name = " + rs.getString("firstName"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public void initDatabase() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:DayTriper.db");
            stmt = conn.createStatement();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e) {
                System.err.println(e);
            }
        }
    }
    public void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:DayTriper.db");
            stmt = conn.createStatement();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e) {
                System.err.println(e);
            }
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection conn;
    private static Statement stmt;

    public Database () throws ClassNotFoundException {
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

    public static void searchQuery(String param) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:DayTriper.db");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(param);
            while(rs.next())
            {
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("firstName = " + rs.getString("firstName"));
                System.out.println("lastName = "+ rs.getString("lastName"));
                System.out.println("gender = "+ rs.getString("gender"));
                System.out.println("age = "+ rs.getString("age"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    // public static void main(String[] args) throws Exception {
    //     Class.forName("org.sqlite.JDBC");
    //     conn = null;
    //     try {
    //         conn = DriverManager.getConnection("jdbc:sqlite:DayTriper.db");
    //         stmt = conn.createStatement();
    //         searchQuery("test");
    //     }
    //     catch(SQLException e) {
    //         System.err.println(e.getMessage());
    //     }
    //     finally {
    //         try {
    //             if(conn != null) {
    //                 conn.close();
    //             }
    //         }
    //         catch(SQLException e) {
    //             System.err.println(e);
    //         }
    //     }
    // }
}
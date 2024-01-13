import java.sql.*;
public class Conexion {
     // static final String DB_URL = "jdbc:mysql://localhost:3306/NAME_DATABASE";
     static final String DB_URL = "jdbc:mysql://localhost:3306/iaiot";
     static final String USER = "root";
     static final String PASS = "mypassword";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
        
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void close(Statement stmt) throws SQLException {
        try {
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        try {
            smtm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void close(Connection conn) throws SQLException {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

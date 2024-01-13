import java.sql.*;

//test mysql con the query
public class  testmysql  {
    // static final String DB_URL = "jdbc:mysql://localhost:3306/NAME_DATABASE";
    static final String DB_URL = "jdbc:mysql://localhost:3306/iaiot";
    static final String USER = "root";
    static final String PASS = "mypassword";
    static final String QUERY = "SELECT * FROM usuarios";

    public static void main(String[] args) {
        // Open a connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 // Execute SQL query
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(QUERY)) {

                // Extract data from the result set
                while (rs.next()) {
                    // Retrieve by column name
                    System.out.print("User: " + rs.getString("user"));
                    System.out.print(", Nombre: " + rs.getString("nombre"));
                    System.out.println(", Tipo: " + rs.getInt("tipo"));
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        } catch (ClassNotFoundException  e) {
            e.printStackTrace(System.out);
        }
    }
}

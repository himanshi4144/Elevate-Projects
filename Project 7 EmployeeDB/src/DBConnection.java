import java.sql.*;

public class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/employeedb";
    static final String USER = "root";
    static final String PASSWORD = "";//enter your sql password here 

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return null;
    }
}

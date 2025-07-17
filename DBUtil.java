package project;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/quiz"; 
        String username = "root";
        String password = "1234";  
        return DriverManager.getConnection(url, username, password);
    }
}

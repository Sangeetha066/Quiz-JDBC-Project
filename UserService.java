package project;

import java.sql.*;
import java.util.Scanner;

public class UserService {
    Scanner sc = new Scanner(System.in);

    public void registerUser() throws SQLException {
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();

        Connection con = DBUtil.getConnection();
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);
        pst.executeUpdate();

        System.out.println("✅ Registration successful!");
    }

    public int loginUser() throws SQLException {
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();

        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            System.out.println("✅ Login successful!");
            return rs.getInt("id");
        } else {
            System.out.println("❌ Invalid credentials.");
            return -1;
        }
    }
}

package project;

import java.sql.*;

public class ResultService {
    public void viewResults(int userId) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM results WHERE user_id = ? ORDER BY date_taken DESC";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, userId);
        ResultSet rs = pst.executeQuery();

        System.out.println("\n📜 Your Quiz History:");
        while (rs.next()) {
            System.out.println("Score: " + rs.getInt("score") +
                " | Date: " + rs.getTimestamp("date_taken"));
        }
    }
}

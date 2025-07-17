package project;

import java.sql.*;
import java.util.Scanner;

public class QuizService {
    Scanner sc = new Scanner(System.in);

    public void takeQuiz(int userId) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT 5";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        int score = 0;

        while (rs.next()) {
            System.out.println("\n" + rs.getString("question_text"));
            System.out.println("A. " + rs.getString("option_a"));
            System.out.println("B. " + rs.getString("option_b"));
            System.out.println("C. " + rs.getString("option_c"));
            System.out.println("D. " + rs.getString("option_d"));
            System.out.print("Your answer: ");
            String ans = sc.nextLine().trim().toUpperCase();

            if (ans.equals(rs.getString("correct_option"))) {
                score++;
            }
        }

        String insert = "INSERT INTO results(user_id, score) VALUES(?, ?)";
        PreparedStatement pst = con.prepareStatement(insert);
        pst.setInt(1, userId);
        pst.setInt(2, score);
        pst.executeUpdate();

        System.out.println("\n🎉 Quiz Completed! Your Score: " + score + "/5");
    }
}


package project;

import java.sql.*;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        QuizService quizService = new QuizService();
        ResultService resultService = new ResultService();

        try {
            while (true) {
                System.out.println("\n===== QUIZ SYSTEM MENU =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    userService.registerUser();
                } else if (choice == 2) {
                    int userId = userService.loginUser();
                    if (userId != -1) {
                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("\n--- User Menu ---");
                            System.out.println("1. Take Quiz");
                            System.out.println("2. View Results");
                            System.out.println("3. Logout");
                            System.out.print("Choose option: ");
                            int option = sc.nextInt();

                            if (option == 1) {
                                quizService.takeQuiz(userId);
                            } else if (option == 2) {
                                resultService.viewResults(userId);
                            } else {
                                loggedIn = false;
                            }
                        }
                    }
                } else {
                    System.out.println("👋 Exiting. Bye!");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


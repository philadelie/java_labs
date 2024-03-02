package ntudp.psj.lab5;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBReader {
    private static final Scanner SC = new Scanner(System.in);
    private static Connection conn;

    public static void main(String[] args) {
        connectToDB();
        selectFromDB();
        disconnectFromDB();
    }

    private static void connectToDB() {
        String url = "jdbc:mysql://0.0.0.0:3306/java_labs";
        String login = "remote";
        String password = login;

        try {
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("Connected to database.");
        } catch (Exception e) { System.out.println("ERROR: " + e.getMessage()); }
    }

    private static void disconnectFromDB() {
        try {
            conn.close();
            System.out.println("Disconnected from database.");
        } catch (Exception e) { System.out.println("ERROR: " + e.getMessage()); }
    }

    private static void selectFromDB() {
        try {
            String sql = "SELECT * FROM students WHERE MONTH(birthday) = " + getMonth();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            printStudentsInfo(rs);
            rs.close();
            stmt.close();
        } catch (Exception e) { System.out.println("ERROR: " + e.getMessage()); }
    }

    private static int getMonth() {
        while (true) {
            System.out.print("Enter month's number: ");
            if (SC.hasNextInt()) {
                int month = SC.nextInt();
                if (month >= 1 && month <= 12) return month;
                else continue;
            }
            SC.next();
        }
    }

    private static void printStudentsInfo(ResultSet rs) {
        try {
            if (!rs.isBeforeFirst()) {
                System.out.println("No students found.");
                return;
            }
            while (rs.next()) {
                String last_name = rs.getString("last_name");
                String first_name = rs.getString("first_name");
                String patronymic = rs.getString("patronymic");
                String birthday = rs.getDate("birthday").toString();
                String record_book = rs.getString("record_book");
                System.out.printf("%s %s %s, %s, record book: %s%n", last_name, first_name, patronymic, birthday, record_book);
            }
        } catch (Exception e) { System.out.println("ERROR: " + e.getMessage()); }
    }
}

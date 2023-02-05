// To insert Data until user enters "exit".

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String []args)throws Exception{
        Scanner scn = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
        System.out.println("Enter the name of the student whose record is need to be deleted");
        String delName = scn.next();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO tbl VALUES (?, ?, ?, ?)");
        String prompt;
        do {
            System.out.println("Enter the name of the student");
            String name = scn.next();
            System.out.println("Enter the roll number of the student");
            int roll = scn.nextInt();
            System.out.println("Enter the marks of the student ");
            int marks = scn.nextInt();
            System.out.println("Enter the faculty of the student ");
            String faculty = scn.next();
            stmt.setString(1, name);
            stmt.setInt(2, roll);
            stmt.setInt(3, marks);
            stmt.setString(4, faculty);
            stmt.executeUpdate();
            System.out.println("Enter 'exit' to exit or any other key to continue");
            prompt = (scn.next().toLowerCase());
        } while (!prompt.equalsIgnoreCase("exit"));
        conn.close();  
    }
}

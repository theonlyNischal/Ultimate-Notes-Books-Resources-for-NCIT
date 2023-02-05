package Database;
import java.io.*;
import java.util.Scanner;
import java.sql.*;
public class Crud {
    public static void main(String []args)throws Exception{
        Scanner scan = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
        PreparedStatement st = cn.prepareStatement("INSERT INTO students Values (?,?,?)");
        int count = 0;
        String prompt;
        do{
            System.out.println("Enter Name : ");
            String name = scan.next();
            System.out.println("Enter roll : ");
            int roll = scan.nextInt();
            System.out.println("Enter faculty : ");
            String faculty = scan.next();
            st.setString(1,name);
            st.setInt(2,roll);
            st.setString(3,faculty);
            st.executeUpdate();

            System.out.println("Enter exit to exit");
            prompt = scan.next().toLowerCase();
        }
        while(!prompt.equalsIgnoreCase("exit"));
        cn.close();
    }
}

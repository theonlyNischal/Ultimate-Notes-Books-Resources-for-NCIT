// Program to show how we can delete and update records in a table.

import java.util.Scanner;
import java.sql.*;

// package Assignments.JDBC Assignment;

public class DatabaseOperations {
    
    public static void main(String []args)throws Exception{
        Scanner scn = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "");
        System.out.println("Enter the name of the student whose record is need to be deleted");
        String delName = scn.next();
        PreparedStatement pstDel = conn.prepareStatement("delete from student where name = ?");
        pstDel.setString(1, delName);
        int delCount = pstDel.executeUpdate();
        if(delCount>0){
            System.out.println(delCount+" record deleted for Students"+delName);
        }
        else{
            System.out.println("Record not found for the student "+delName);
        }
        System.out.println("Enter the name of the student whose record is need to be updated");
        String updName = scn.next();
        System.out.println("Enter the roll number of the student whose record is need to be updated");
        int updRoll = scn.nextInt();
        PreparedStatement pstUpd = conn.prepareStatement("update student set name = ? where roll = ?");
        pstUpd.setString(1, updName);
        pstUpd.setInt(2, updRoll);
        int updCount = pstUpd.executeUpdate();
        if(updCount>0){
            System.out.println(updCount+" record updated for Students"+updName);
        }
        else{
            System.out.println("Record not found for the student "+updName);
        }
        conn.close();
    }
}

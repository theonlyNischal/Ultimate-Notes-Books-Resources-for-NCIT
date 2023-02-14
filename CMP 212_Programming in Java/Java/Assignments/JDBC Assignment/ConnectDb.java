import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDb {
    public void displayMenu() {
        System.out.println("******************MENU****************");
        System.out.println("1 -> Display all records");
        System.out.println("2 -> Display total number of records");
        System.out.println("3 -> Display records by name");
        System.out.println("4 -> Display average marks of all students");
        System.out.println("5 -> Display average marks of respective faculty");
    
    }
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncit", "root", "");
    
        ConnectDb obj = new ConnectDb();
    
        obj.displayMenu();
        System.out.println("Enter choice : ");
        int ch = scn.nextInt();
    
        switch (ch) {
            case 1:
                obj.displayAllRecords(conn);
                break;
            case 2:
                obj.displayNumberOfRecords(conn);
                break;
            case 3:
                obj.displayByName(conn);
                break;
            case 4:
                obj.displayAverageMarks(conn);
                break;
            case 5:
                obj.displayMarksByFaculty(conn);
                break;
    
            default:
                System.out.println("Invalid");
        }
    }
    static Scanner scn = new Scanner(System.in);

    public void displayAllRecords(Connection c) throws SQLException {
        PreparedStatement pst = c.prepareStatement("SELECT * FROM student");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println("Roll Number : " + rs.getInt(1));
            System.out.println("Name : " + rs.getString(2));
            System.out.println("Faculty : " + rs.getString(3));
            System.out.println("Marks : " + rs.getInt(4));
        }
    }

    public void displayNumberOfRecords(Connection c) throws SQLException {
        PreparedStatement pst = c.prepareStatement("SELECT COUNT(roll) FROM student");
        ResultSet rs = pst.executeQuery();
        rs.next();
        System.out.println("The total number of records present are : " + rs.getInt(1));
    }

    public void displayByName(Connection c) throws SQLException {
        System.out.println("Enter the name present in DataBase : ");
        String inName = scn.next();
        PreparedStatement pst = c.prepareStatement("SELECT COUNT(name) FROM student WHERE name = ?");
        pst.setString(1, inName);
        ResultSet rs = pst.executeQuery();
        rs.next();
        System.out.println("The total number of records of name " + inName + " is : " + rs.getInt(1));
    }

    public void displayAverageMarks(Connection c) throws SQLException {
        PreparedStatement pst = c.prepareStatement("SELECT AVG(marks) FROM student");
        ResultSet rs = pst.executeQuery();
        rs.next();
      System.out.println("The average marks of the students is : " + rs.getInt(1));
    }

    public void displayMarksByFaculty(Connection c) throws SQLException {
        System.out.println("Enter the Faculty : ");
        String inFaculty = (scn.next()).toLowerCase();

        PreparedStatement pst = c.prepareStatement("SELECT AVG(marks) FROM student WHERE faculty = ?");
        pst.setString(1, inFaculty);
        ResultSet rs = pst.executeQuery();
        rs.next();
        System.out.println("The average marks from faculty " + inFaculty + " is : " + rs.getInt(1));
    }

}
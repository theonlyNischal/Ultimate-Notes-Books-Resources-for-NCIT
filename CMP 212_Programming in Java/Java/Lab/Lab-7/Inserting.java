import java.sql.*;
import java.util.Scanner;

class Inserting{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
    try{
        String url="jdbc:mysql://localhost:3306/kamal";
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn=DriverManager.getConnection(url,"root","");
        PreparedStatement st=cn.prepareStatement("INSERT INTO Studens values(roll,name,faculty)");
        String prompt;
        do{
            System.out.println("Enter roll no: ");
            int roll=scan.nextInt();
            System.out.println("Enter name: ");
            String name=scan.next();
            System.out.println("Enter faculty: ");
            String faculty=scan.next();
            st.setInt(1,roll);
            st.setString(2,name);
            st.setString(3,faculty);
            ResultSet rs=st.executeQuery();
            System.out.println("Enter n to exit or any key to continue: ");
            prompt=scan.next();
        }while(!(prompt.toLowerCase().startsWith("n")));
    }catch(ClassNotFoundException e){
        System.out.println(e.getMessage());
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    scan.close();
    } 
}
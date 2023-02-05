import java.sql.*;
import java.util.Scanner;

class Database {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Database dbase = new Database();
        Connection cn = dbase.getConnection();
        int choice;
        dbase.showMenu();
        do {
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    dbase.addStudent(cn);
                    break;
                case 2:
                    dbase.updateStudent(cn);
                    break;
                case 3:
                    dbase.deleteStudent(cn);
                    break;
                case 4:
                    dbase.showAllStudents(cn);
                    break;
                case 5:
                    cn.close();
                    break;
                default:
                    System.out.println("Invalid choice");
                    dbase.showMenu();
            }
        } while (choice != 5);
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/nischal";
        String username = "root";
        String password = "";
        Connection cn = DriverManager.getConnection(url, username, password);
        return cn;

    }

    public void showMenu() {
        System.out.println("**************MENU**************");
        System.out.println("1. Add new student");
        System.out.println("2. Update student");
        System.out.println("3. Delete student");
        System.out.println("4. Show all students");
        System.out.println("5. Close Connection");
    }

    public void addStudent(Connection cn) throws SQLException {
        System.out.println("Enter student name");
        String name = sc.next();
        System.out.println("Enter student faculty");
        String faculty = sc.next();
        String sql = "insert into student(name,faculty) values(?,?)";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, faculty);
        int result = ps.executeUpdate();
        if (result == 1) {
            System.out.println("Student added successfully");
        } else {
            System.out.println("Student not added");
        }
    }

    public void updateStudent(Connection cn) throws SQLException {
        System.out.println("Enter student id");
        int id = sc.nextInt();
        System.out.println("Enter student name");
        String name = sc.next();
        System.out.println("Enter student faculty");
        String faculty = sc.next();
        String sql = "update student set name=?,faculty=? where id=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, faculty);
        ps.setInt(3, id);
        int result = ps.executeUpdate();
        if (result == 1) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not updated");
        }
    }

    public void deleteStudent(Connection cn) throws SQLException {
        System.out.println("Enter student id");
        int id = sc.nextInt();
        String sql = "delete from student where id=?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        if (result == 1) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not deleted");
        }
    }

    public void showAllStudents(Connection cn) throws SQLException {
        String sql = "select * from student";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + "      Name: " + rs.getString("name") + "       Faculty: "
                    + rs.getString("faculty"));
            System.out.println("********************************");
        }
    }
}
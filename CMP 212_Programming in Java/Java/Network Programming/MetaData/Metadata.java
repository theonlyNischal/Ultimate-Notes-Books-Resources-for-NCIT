package Practice.MetaData;

import java.sql.*;

public class Metadata {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradeep", "root", "");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from student");
        ResultSetMetaData rsmd = rs.getMetaData();
        int col = rsmd.getColumnCount();
        System.out.println("Total columns: " + col);
        System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
        System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));
        System.out.println("Column Type of 1st column: " + rsmd.getColumnType(1));
        System.out.println("Column Size of 1st column: " + rsmd.getColumnDisplaySize(1));

    }
}

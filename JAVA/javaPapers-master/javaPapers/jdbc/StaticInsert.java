import java.sql.*;

class StaticInsert
{
  public static void main(String args[])
  {
    Connection con=null;
    try{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("jdbc:odbc:summit_datasource","sa","orchid");
    String sql="delete from tbltes where id=3";
    Statement st=con.createStatement();
    st.executeUpdate(sql);
    System.out.println("Record updated");
    con.close();
    }
    catch(ClassNotFoundException e)
    {
      System.out.println(e);
    }
    catch(SQLException e)
    {
      System.out.println(e);
    }
   }
}
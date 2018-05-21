import java.sql.*;

class StaticSelect
{
  public static void main(String args[])
  {
    Connection con=null;
    try{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("jdbc:odbc:summit_datasource","sa","orchid");
    String sql="select * from tbltes";
    Statement st=con.createStatement();
   ResultSet rs= st.executeQuery(sql);
   System.out.println("ID\tName\tAddress");
   while(rs.next())
   {
     System.out.print(rs.getString(1)+"\t");
     System.out.print(rs.getString(2)+"\t");
     System.out.println(rs.getString(3));
   }
   
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
import java.sql.*;
import java.io.*;

public class saveImage 
{
        public static void main(String[] args) 
        {
                DB db = new DB();
                Connection conn=db.dbConnect();
                db.insertImage(conn);
                db.getImageData(conn);
        }

}

class DB
{
        public DB() {}

        public Connection dbConnect()
        {
                try
                {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        Connection conn = DriverManager.getConnection("jdbc:odbc:mydatasource","sa","orchid");

                        System.out.println("connected");
                        return conn;
                        
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        return null;
                }
        }

   public void insertImage(Connection conn)
   {
         int len;
         String query;
         PreparedStatement pstmt;
                
        try
         {
       File file = new File("android.png");                  FileInputStream fis = new FileInputStream(file);
       len = (int)file.length();

 query = ("insert into TableImage VALUES(?,?,?)");
   pstmt = conn.prepareStatement(query);
                        pstmt.setString//(1,file.getName());
                      //  pstmt.setInt(2, len);
  
      // Method used to insert a stream of bytes
          pstmt.setBinaryStream(3, fis, len); 
           pstmt.executeUpdate();

                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }

       public void getImageData(Connection conn)
        {
                 byte[] fileBytes;
                 String query;
                 try
                 {
         query = "select pic from TableImage";
       Statement state = conn.createStatement();
       ResultSet rs = state.executeQuery(query);
        if (rs.next())
         {
                fileBytes = rs.getBytes(1);
          OutStream targetFile= new FileOutputStream("d:/new.JPG");
          targetFile.write(fileBytes);
          targetFile.close();
                        }        
                        
                 }
                 catch (Exception e)
                 {
                         e.printStackTrace();
                 }
        }
} 
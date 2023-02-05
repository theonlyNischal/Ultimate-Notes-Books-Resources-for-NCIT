import java.sql.*;

class Specific{
    public static void main(String[] args){
        String url="jdbc:mysql://localhost:3306/kamal";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection(url,"root","");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM Students Where faculty='SE'");
            int count=0;
            while(rs.next()){
                count=count+1;
            }
            System.out.println("Number of SE Students present are: "+count);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
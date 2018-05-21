package com.orchid.controller;
import com.orchid.common.DBConnection;
import com.orchid.common.TrackUser;
import com.orchid.model.Login;
import java.sql.*;
public class LoginController {
    public int validateUser(Login ob){
        Connection con=null;
        int status=-1;
        try{
            con=DBConnection.getConnection();
            String sql="select * from login where username=? and password=md5(?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, ob.getUsername());
            pst.setString(2, ob.getPassword());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                int id=rs.getInt("id");
                String username=rs.getString("username");
                TrackUser.id=id;
                TrackUser.username=username;
                status=rs.getInt("status");
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        return status;
    }
}

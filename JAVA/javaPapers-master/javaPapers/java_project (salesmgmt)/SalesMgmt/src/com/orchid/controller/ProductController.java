/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchid.controller;

import com.orchid.common.DBConnection;
import com.orchid.model.Product;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ProductController {
    public void saveProduct(Product ob){
        Connection con=null;
        try{
            con=DBConnection.getConnection();
            String sql="insert into product(names,price,qty,remarks)values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getNames());
            pst.setDouble(2, ob.getPrice());
            pst.setInt(3, ob.getQty());
            pst.setString(4, ob.getRemarks());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Saved");
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
    }
    public ArrayList<Product> fetchData(){
        ArrayList<Product> list=new ArrayList();
        Connection con=null;
        try{
            con=DBConnection.getConnection();
            String sql="select * from product";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                Product ob=new Product();
                ob.setId(rs.getInt("id"));
                ob.setNames(rs.getString("names"));
                ob.setPrice(rs.getDouble("price"));
                ob.setQty(rs.getInt("qty"));
                ob.setRemarks(rs.getString("remarks"));
                list.add(ob);
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
        return list;
    }
    
    public void deleteProduct(int id){
        Connection con=null;
        try{
            con=DBConnection.getConnection();
            String sql="delete from product where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Deleted");
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
    }
    
    public void updateProduct(Product ob){
        Connection con=null;
        try{
            con=DBConnection.getConnection();
            String sql="update product set names=?,price=?,qty=?,remarks=? where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getNames());
            pst.setDouble(2,ob.getPrice());
            pst.setInt(3,ob.getQty());
            pst.setString(4,ob.getRemarks());
            pst.setInt(5,ob.getId());
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Record Updated");
            
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
    }
    
    public Product fetchData(int id){
        Connection con=null;
       
        try{
            con=DBConnection.getConnection();
            String sql="select * from product where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                 Product ob=new Product();
                ob.setId(rs.getInt("id"));
                ob.setNames(rs.getString("names"));
                ob.setPrice(rs.getDouble("price"));
                ob.setQty(rs.getInt("qty"));
                ob.setRemarks(rs.getString("remarks"));
                return ob;
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
        return null;
    }
    
    public int getQty(int id,Connection con){
        int qty=0;
        try{
            String sql="select qty from product where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                qty=rs.getInt("qty");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return qty;
    }
    
    public void updateQty(int id,int newQty,Connection con){
        try{
            String sql="update product set qty=? where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,newQty);
            pst.setInt(2,id);
            pst.execute();
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }
}

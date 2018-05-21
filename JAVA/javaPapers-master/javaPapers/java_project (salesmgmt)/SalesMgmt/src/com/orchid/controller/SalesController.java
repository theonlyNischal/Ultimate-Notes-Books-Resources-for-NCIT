/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchid.controller;

import com.orchid.common.DBConnection;

import com.orchid.model.Sales;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Nabin
 */
public class SalesController {
    public void saveData(ArrayList<Sales> list){
        Connection con=null;
        try{
            con=DBConnection.getConnection();
            con.setAutoCommit(false);
            for(int i=0;i<list.size();i++){
                String sql="insert into sales(pid,sid,qty,dos)values(?,?,?,?)";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setInt(1, list.get(i).getPid());
                pst.setInt(2,list.get(i).getSid());
                pst.setInt(3, list.get(i).getQty());
                pst.setDate(4, new java.sql.Date(list.get(i).getDos().getTime()));
                pst.execute();
                //get stock quantity from Product table
                ProductController pdc=new ProductController();
                int qty=pdc.getQty(list.get(i).getPid(),con);
                
                //update stock quantity of product table
                int newQty=qty-list.get(i).getQty();
                pdc.updateQty(list.get(i).getPid(),newQty,con);
                con.commit();
                
            }
        }catch(Exception ex){
            System.out.println(ex);
            try{
                con.rollback();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}

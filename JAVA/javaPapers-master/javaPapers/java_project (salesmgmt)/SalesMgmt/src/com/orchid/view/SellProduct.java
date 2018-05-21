/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchid.view;

import com.orchid.common.TrackUser;
import com.orchid.controller.ProductController;
import com.orchid.controller.SalesController;
import com.orchid.model.Product;
import com.orchid.model.Sales;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nabin
 */
public class SellProduct extends javax.swing.JInternalFrame {
    DefaultTableModel model;
    
    private void printBill(){
        int count=jTable_Sales.getRowCount();
        String str="Namaste Super Market\nNewroad,Kathmandu\n";
        for(int i=0;i<count;i++){
            str+=jTable_Sales.getValueAt(i, 0).toString()+"  ";
            str+=jTable_Sales.getValueAt(i, 1).toString()+"  ";
            str+=jTable_Sales.getValueAt(i, 2).toString()+"  ";
            str+=jTable_Sales.getValueAt(i, 3).toString()+"  ";
            str+=jTable_Sales.getValueAt(i, 4).toString()+"\n";
      }
           str+="Grand Total: "+jLabel_GrandTotal.getText();
           str+="\nThank You For Visiting!!!";
           
           BillPrint ob=new BillPrint();
           ob.jTextArea_Bill.setLineWrap(true);
           ob.jTextArea_Bill.setText(str);
           try{
           ob.jTextArea_Bill.print();
           }catch(Exception ex){
               System.out.println(ex);
           }
           
    }
    public SellProduct() {
        initComponents();
        jLabel_Date.setText(new java.util.Date().toString());
        model=new DefaultTableModel(null,new String[]
                           {"Pid","Name","Price","Qty","Total"});
        jTable_Sales.setModel(model);
        
        jLabel_Login.setText("Logged In As "+TrackUser.username);
    }

    private void computeGrandTotal(){
        int count=jTable_Sales.getRowCount();
        double total=0;
        for(int i=0;i<count;i++){
        double amt=
           Double.parseDouble(jTable_Sales.getValueAt(i, 4).toString());
            total+=amt;
        }
        jLabel_GrandTotal.setText(total+"");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_ProductId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Sales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel_GrandTotal = new javax.swing.JLabel();
        jButton_DeleteRow = new javax.swing.JButton();
        jButton_SaveAndPrint = new javax.swing.JButton();
        jLabel_Login = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Sell Product");

        jLabel_Date.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel_Date.setText("Date");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Product Id");

        jTextField_ProductId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField_ProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ProductIdActionPerformed(evt);
            }
        });

        jTable_Sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_Sales);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Grand Total");

        jLabel_GrandTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_GrandTotal.setText("GT");

        jButton_DeleteRow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_DeleteRow.setText("Delete Row");
        jButton_DeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteRowActionPerformed(evt);
            }
        });

        jButton_SaveAndPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_SaveAndPrint.setText("Save And Print");
        jButton_SaveAndPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveAndPrintActionPerformed(evt);
            }
        });

        jLabel_Login.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel_Login.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel_GrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(44, 44, 44)
                                .addComponent(jTextField_ProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_DeleteRow)
                                .addGap(10, 10, 10)))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_SaveAndPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Date)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_ProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_DeleteRow)
                        .addGap(8, 8, 8)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel_GrandTotal))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_SaveAndPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Login))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_ProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ProductIdActionPerformed
        // TODO add your handling code here:
        String str=jTextField_ProductId.getText();
        if(!str.equals(""))
        {
            int pid=Integer.parseInt(str);
            ProductController pdc=new ProductController();
            Product ob=pdc.fetchData(pid);
            if(ob!=null){
             model.addRow(new Object[]{ob.getId(),ob.getNames(),ob.getPrice(),"1",ob.getPrice()});
             computeGrandTotal();
            }
        }
        
    }//GEN-LAST:event_jTextField_ProductIdActionPerformed

    private void jButton_DeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteRowActionPerformed
        // TODO add your handling code here:
        int rowIndex=jTable_Sales.getSelectedRow();
        if(rowIndex>=0){
            model.removeRow(rowIndex);
            computeGrandTotal();
        }
    }//GEN-LAST:event_jButton_DeleteRowActionPerformed

    private void jButton_SaveAndPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveAndPrintActionPerformed
        // TODO add your handling code here:
        ArrayList<Sales> list=new ArrayList();
        int count=jTable_Sales.getRowCount();
        for(int i=0;i<count;i++){
            Sales ob=new Sales();
            int pid=Integer.parseInt(jTable_Sales.getValueAt(i,0).toString());
            int sid=TrackUser.id;
            int qty=Integer.parseInt(jTable_Sales.getValueAt(i,3).toString());
            java.util.Date d=new java.util.Date();
            
            ob.setPid(pid);
            ob.setSid(sid);
            ob.setQty(qty);
            ob.setDos(d);
            list.add(ob);
        }   
        SalesController sdc=new SalesController();
        sdc.saveData(list);
        JOptionPane.showMessageDialog(null,"Record Saved");
        printBill();
    }//GEN-LAST:event_jButton_SaveAndPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DeleteRow;
    private javax.swing.JButton jButton_SaveAndPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Date;
    private javax.swing.JLabel jLabel_GrandTotal;
    private javax.swing.JLabel jLabel_Login;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Sales;
    private javax.swing.JTextField jTextField_ProductId;
    // End of variables declaration//GEN-END:variables
}

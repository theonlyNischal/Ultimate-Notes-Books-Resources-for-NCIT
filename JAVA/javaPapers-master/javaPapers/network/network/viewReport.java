import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.*;
import java.sql.*;

class viewReport extends JFrame{// implements ActionListener{
 JasperPrint JPrint;
 JButton btnShowReport;
 JButton btnAbout;
 JButton btnExit;
 
// CONTRUCTOR
 public viewReport(){
  initComponent();
  design();
 }
// INITIALIZE GUI COMPONENTS
 public void initComponent(){
  btnShowReport=new JButton("SHOW REPORT");
  btnShowReport.setMnemonic('S');
 // btnShowReport.addActionListener(this);

  btnAbout=new JButton("ABOUT");
  btnAbout.setMnemonic('A');
 // btnAbout.addActionListener(this);

  btnExit=new JButton("EXIT");
  btnExit.setMnemonic('X');
  //btnExit.addActionListener(this);
 }

 // DESIGN THE FORM
 public void design(){
  setTitle("View Report");
  getContentPane().setLayout(new FlowLayout());
  getContentPane().add(btnShowReport);
  getContentPane().add(btnAbout);
  getContentPane().add(btnExit);
  pack();
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  show();
 }

/* // SHOW THE REPORT
 public void showReport(){
  try{
   // PREPARING DATABASE CONNECTION
   //String jdbcDriver = "com.mysql.jdbc.Driver";
  // Class.forName(jdbcDriver);
   //String url = "jdbc:mysql://localhost/contact";
  // String user = "user1";
   //String pass = "12345";
 
   Connection con = DriverManager.getConnection("jdbc:odbc:MyDataSource","sa","lbef");

   // PATH TO YOUR JASPER FILE
   String fullPath="C:/Users/nabin/report1.jasper";
   // FILL THE REPORT
   JPrint=JasperFillManager.fillReport(fullPath,null,con);
   // VIEW THE REPORT
   JasperViewer.viewReport(JPrint,false);
  }
  catch(Exception ex){
   System.out.println(ex.toString());
  }
 }
*/
 
 public static void main(String[] args){
 viewReport ob= new viewReport();
ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ob.setVisible(true);
ob.setSize(200,200);
 }

/* // EVENT LISTENER
 public void actionPerformed(ActionEvent ae){
  // IF SHOW BUTTON CLICKED, SHOW THE REPORT
  if(ae.getSource()==btnShowReport)
   showReport();
  // THE OTHER BUTTONS
  if(ae.getSource()==btnExit)
   dispose();
  if(ae.getSource()==btnAbout)
   JOptionPane.showMessageDialog(this,"Jasper Report Viewer.\nCreated by: Lucky\nE-mail: lucky_iboyz@yahoo.com or bogeyman2007@gmail.com","About",JOptionPane.INFORMATION_MESSAGE);
 }
*/
}

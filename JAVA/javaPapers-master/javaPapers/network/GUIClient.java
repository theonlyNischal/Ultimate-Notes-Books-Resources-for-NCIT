import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUIClient extends JFrame implements ActionListener
{
  JTextField t1;
  static JTextArea ta;
  JButton b1;
  static Socket s;
  static BufferedReader serverInput ;
  static PrintWriter clientOutput;
  GUIClient()
  {
    setLayout(new BorderLayout());
    setTitle("Chat Client");
    
    ta=new JTextArea();
    add(ta,BorderLayout.CENTER);
    
    JPanel p=new JPanel();
    t1=new JTextField(20);
    p.add(t1);
    b1=new JButton("Send");
    p.add(b1);
    add(p,BorderLayout.SOUTH);
    
    b1.addActionListener(this);
    setSize(350,350);
    setVisible(true);
  }
  public static void main(String args[])
  {
    java.awt.EventQueue.invokeLater(new Runnable(){
      public void run(){   
      new GUIClient();
      }
    });
    String msgin="";
    try{
      s=new Socket("nd",9876);
      serverInput=new BufferedReader(new InputStreamReader(s.getInputStream()));
      clientOutput=new PrintWriter(s.getOutputStream());
      String msg="";
      while(!msg.equals("exit")){
      msgin=serverInput.readLine();
      ta.setText(ta.getText().trim()+"\n"+msgin);
      }
     // s.close();
      //serverInput.close();
      //clientOutput.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  public void actionPerformed(ActionEvent e)
  {
    String userInput=t1.getText();
    if(e.getSource()==b1)
    {
      
      clientOutput.println(userInput);
      System.out.println("hello");
    }
     
  }
  }
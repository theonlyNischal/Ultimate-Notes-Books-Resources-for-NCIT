import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUIServer extends JFrame implements ActionListener
{
  JTextField t1;
  static JTextArea ta;
  JButton b1;
  static ServerSocket ss;
  static Socket s;
  static BufferedReader clientInput;
  static PrintWriter serverOutput;
  GUIServer()
  {
    setLayout(new BorderLayout());
    setTitle("Chat Server");
    
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
      new GUIServer();
      }
    });
    String msgin="";
    try{
      ss=new ServerSocket(9876);
      s=ss.accept();
      clientInput=new BufferedReader(new InputStreamReader(s.getInputStream()));
      serverOutput=new PrintWriter(s.getOutputStream());
      String msg="";
      while(!msg.equals("exit")){
      msgin=clientInput.readLine();
      ta.setText(ta.getText().trim()+"\n"+msgin);
      }
      //ss.close();
      //s.close();
      //clientInput.close();
      //serverOutput.close();
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
      serverOutput.println(userInput);
    }
     
  }
  }
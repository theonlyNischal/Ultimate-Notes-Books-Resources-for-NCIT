import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class LoginDemo extends JFrame implements ActionListener
{
  JPopupMenu popup;
  JMenuItem mi1;
  JButton b1,b2;
  JTextField t1;
  JPasswordField p1;
 // JInternalFrame frame;
  LoginDemo()
  {
 //   frame=new JInternalFrame();
    setLayout(new FlowLayout());
   
    JLabel l1=new JLabel("Username");
    add(l1);
    t1=new JTextField(20);
    add(t1);
    JLabel l2=new JLabel("Password");
    add(l2);
    p1=new JPasswordField(20);
    add(p1);
    
    b1=new JButton("ok");
    b2=new JButton("cancel");
    add(b1);
    add(b2);
    b1.addActionListener(new ActionListener()
                           {
      public void actionPerformed(ActionEvent e)
      {
        System.out.println("Button one clicked");
      }});
    b2.addActionListener(this);
    
    /*popup=new JPopupMenu();
    mi1=new JMenuItem("Exit");
    popup.add(mi1);
    b1.setComponentPopupMenu(popup);
    */
    ImageIcon img=new ImageIcon("android.png");
    //setFrameIcon(img);
    setTitle("User Login");
    setSize(240,200);
    setVisible(true);
    //setClosable(true);
  
  }
  public static void main(String args[])
  {
    new LoginDemo();
  }
  public void actionPerformed(ActionEvent e)
  {
  /*  if(e.getSource()==b1)
    {
      String uname=t1.getText();
      String pwd=new String(p1.getPassword());
      
      if(uname.equals("ram") && pwd.equals("ram"))
      {
        new BorderDemo();
        setVisible(false);
      }
    }*/
    if(e.getSource()==b2)
    {
      dispose();
    }
  }
}
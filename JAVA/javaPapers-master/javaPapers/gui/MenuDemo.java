import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuDemo implements ActionListener
{
  JCheckBoxMenuItem mi1,mi2;
  MenuDemo()
  {
      JFrame frame=new JFrame();
    frame.setLayout(new BorderLayout());
    
 
    JMenuBar mbar=new JMenuBar();
  // frame.add(mbar,BorderLayout.NORTH);
    frame.setJMenuBar(mbar);
    
   // JToolBar tbar=new JToolBar();
    
    
    JMenu admin=new JMenu("Admin");
     admin.setMnemonic('a');
    mi1=new JCheckBoxMenuItem("Login");
    admin.add(mi1);
    admin.addSeparator();
    
    ImageIcon icon=new ImageIcon("f:/javapr/gui/device.ico");
     mi2=new JCheckBoxMenuItem("Logout user",icon);
     mi2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
   //  mi2.setIcon(icon);
    admin.add(mi2);
    admin.setToolTipText("Admin Menu");
   
    
      ButtonGroup bg=new ButtonGroup();
    bg.add(mi1);
    bg.add(mi2);
    mi2.setEnabled(false);
    mbar.add(admin);
    
    JMenu user=new JMenu("User");
    user.setMnemonic('b');
    JMenuItem mi3=new JMenuItem("Login");
    user.add(mi3);
    user.setEnabled(false);
    JMenuItem mi4=new JMenuItem("Logout");
    user.add(mi4);
    mbar.add(user);
    
    frame.setVisible(true);
    frame.setSize(200,200);
    mi1.addActionListener(this);
    
  }
  public static void main(String args[])
  {
    new MenuDemo();
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==mi1)
    { 
     new LoginDemo();
    }
         
      
  }
}
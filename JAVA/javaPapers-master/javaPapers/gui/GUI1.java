import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class GUI1  implements ActionListener
{
    GUI1()
    {
       JFrame frame=new JFrame();
       frame.setLayout(new FlowLayout());
       
       
// Border border = BorderFactory.createLineBorder(Color.BLUE, 1); 
//Border border = BorderFactory.createTitledBorder("check"); 
//Border border = BorderFactory.createEtchedBorder(); 
//Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED); //LOWERED by default
//Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.BLUE, Color.RED); //first color highlight, second color shadow
//Border border = BorderFactory.createMatteBorder(5,5,5,5,Color.RED); //int top,left, bottom right and color 
ImageIcon img=new ImageIcon("android.png");
Border border = BorderFactory.createMatteBorder(5,5,5,5,img);       
// set the border of this component 
JLabel label=new JLabel("bordered text");
label.setBorder(border); 
frame.add(label);
    
    JButton b=new JButton("Click Me");
   // b.setBounds(30,50,100,30);
    frame.add(b);
    b.setBorder(border);
    b.addActionListener(this);
    
    frame.setSize(200,200);
    frame.setVisible(true);
    }

  public void actionPerformed(ActionEvent e)
  {
    JOptionPane.showMessageDialog(null,"hello");
  }
  public static void main(String args[])
  {
   new GUI1();

  }
}
    
    
    
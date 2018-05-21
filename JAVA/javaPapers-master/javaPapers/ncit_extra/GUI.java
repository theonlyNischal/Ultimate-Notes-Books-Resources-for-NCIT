import javax.swing.*;
class GUI
{
   JFrame f1;
   GUI()
   {
 f1=new JFrame("This is swing frame");
 //f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(300,300);
 f1.setVisible(true);
   }
   public static void main(String args[])
   {
 new GUI();
    }
}
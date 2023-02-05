import javax.swing.*;
import java.awt.event.*;
public class MyMessageDialog implements WindowListener{
    JFrame frame;
    
    public MyMessageDialog(){
        frame = new JFrame("MessageDialog");
        frame.setSize(300, 400);
        frame.addWindowListener(this);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    public void windowClosing(WindowEvent e){
        JOptionPane.showMessageDialog(null, "Do you really want to CONTINUE ?");
    }


    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e) {}
    
    public static void main(String[] args) {
        new MyMessageDialog();
    }
    
}

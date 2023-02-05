import javax.swing.*;
import java.awt.event.*;

class WindowConfirm extends JFrame implements WindowListener{
    public WindowConfirm(){
        setSize(500,500);
        setTitle("Window Listener Example!");
        setVisible(true);
        addWindowListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    public void windowClosing(WindowEvent e){
        int a=JOptionPane.showConfirmDialog(this,"Do you want to exit?");
        if(a==JOptionPane.YES_OPTION){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public static void main(String[] args){
        new WindowConfirm();
    }
}

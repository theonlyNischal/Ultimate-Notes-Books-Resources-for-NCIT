package component;

import com.obs.gui.swing.interfaces.ClosableTabbedPane;
import javax.swing.*;
import java.awt.*;

public class TabDemo {
    ClosableTabbedPane tab;
    JFrame f1;
    TabDemo(){
        f1=new JFrame("test");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(500,500);
        f1.setLayout(new BorderLayout());
        
        tab=new ClosableTabbedPane();
        JPanel p1=new JPanel();
        JButton b1=new JButton("hello");
        p1.add(b1);
        tab.addTab("Tab1",p1);
        f1.add(tab);
        f1.setVisible(true);
        
    }
    public static void main(String args[]){
        new TabDemo();
    }
}
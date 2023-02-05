import javax.swing.*;
import java.awt.event.*;

/**
 * MyMenu
 */
public class MyMenu extends JFrame implements ActionListener{
    JMenu menu;
    JMenuBar bar;
    JMenuItem select, copy, cut, paste, exit;
    JTextArea area;
    public MyMenu(){
        setSize(300, 400);
        menu = new JMenu("menu");
        bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(menu);
        select = new JMenuItem("Select");
        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        exit = new JMenuItem("Exit");
        area = new JTextArea("pokhara university");
        area.setBounds(140, 300, 150, 100);
        menu.add(select);
        menu.add(copy);
        menu.add(cut);
        menu.add(paste);
        add(area);
        menu.addSeparator();
        menu.add(exit);
        setLayout(null);
        setVisible(true);
        select.addActionListener(this);
        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        exit.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public void actionPerformed(ActionEvent e){
    Object source = e.getSource();
    if(source == select){
        area.selectAll();
    }else if(source == copy){
        area.copy();
    }else if(source == cut){
        area.cut();
    }else if(source == paste){
        area.paste();
    }else{
        System.exit(0);
    }
}
public static void main(String[] args) {
    new MyMenu();
}
}



import javax.swing.*;
import java.awt.event.*;

class PopUpMenu extends JFrame implements MouseListener, ActionListener{
    JPopupMenu menu;
    JMenuItem select, copy, cut, paste,exit;
    JTextArea text;
    public PopUpMenu(){
        setSize(800,800);
        menu = new JPopupMenu();
        select = new JMenuItem("Select All");
        menu.add(select);
        copy = new JMenuItem("Copy");
        menu.add(copy);
        cut = new JMenuItem("Cut");
        menu.add(cut);
        paste = new JMenuItem("Paste");
        menu.add(paste);
        exit = new JMenuItem("Exit");
        menu.add(exit);
        text = new JTextArea("Written By Pradip Dhungana");
        text.setBounds(30,30,500,500);
        add(text);
        setLayout(null);
        setVisible(true);
        select.addActionListener(this);
        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        exit.addActionListener(this);
        text.addMouseListener(this);
        addMouseListener(this);
    }
    public void mouseClicked(MouseEvent e){
            menu.show(this, e.getX(), e.getY());
        }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
   
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==select){
            text.selectAll();
        }
        else if(e.getSource()==copy){
            text.copy();
        }
        else if(e.getSource()==cut){
            text.cut();
        }
        else if(e.getSource()==paste){
            text.paste();
        }
        else{
            System.exit(0);
        }
    }
    public static void main(String args[]) {
        new PopUpMenu();
    }
}

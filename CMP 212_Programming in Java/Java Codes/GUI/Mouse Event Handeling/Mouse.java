// THIS PROGRAM DEMONSTRATES ALL MOUSE EVENTS

import javax.swing.*;
import java.awt.event.*;

class Mouse implements MouseListener, MouseMotionListener{
    JFrame f;
    JTextField t1,t2,t3,t4;
    public Mouse(){
        f = new JFrame();
        f.setSize(800,1000);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t1.setBounds(50,50,100,30);
        t2.setBounds(50,100,100,30);
        t3.setBounds(50,200,100,30);
        t4.setBounds(50,300,100,30);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.setLayout(null);
        f.setVisible(true);
        f.addMouseListener(this);
        f.addMouseMotionListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void mouseClicked(MouseEvent e){
        t1.setText("Mouse Clicked");
    }
    public void mouseReleased(MouseEvent e){
        t1.setText("Mouse Released");
    }
    public void mouseEntered(MouseEvent e){
        t2.setText("Mouse IN!");
    }
    public void mouseExited(MouseEvent e){
        t2.setText("Mouse OUT!");
    }
 
    public void mousePressed(MouseEvent e){
        t3.setText("Mouse Pressed");
    }
  
    public void mouseDragged(MouseEvent e){
        t3.setText("Mouse Dragged");
    }
    public void mouseMoved(MouseEvent e){
        String cord = "X: "+e.getX()+" Y: "+e.getY();
        t4.setText(cord);
    }
    public static void main(String args[]) {
        new Mouse();
    }
}
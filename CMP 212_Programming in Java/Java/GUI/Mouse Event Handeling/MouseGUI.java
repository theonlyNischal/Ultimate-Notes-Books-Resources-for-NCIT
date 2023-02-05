
import java.awt.*;
import java.awt.event.*;

class MouseGUI implements MouseListener, MouseMotionListener{
    TextField t1,t2;
    public MouseGUI(){
        Frame f=new Frame("MouseEvent Example!");
        f.setSize(500,500);
        t1=new TextField();
        t2=new TextField();
        t1.setBounds(100,150,150,60);
        t2.setBounds(100,250,150,60);
        f.add(t1);
        f.add(t2);
        f.addMouseListener(this);
        f.addMouseMotionListener(this);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void mouseMoved(MouseEvent e){
        t1.setText("X: "+e.getX()+"\tY: "+e.getY());
    }
    public void mouseEntered(MouseEvent e){
        t2.setText("IN!");
    }
    public void mouseExited(MouseEvent e){
        t2.setText("OUT!");
    }
    public void mouseDragged(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public static void main(String [] args){
        new MouseGUI();
    }
}

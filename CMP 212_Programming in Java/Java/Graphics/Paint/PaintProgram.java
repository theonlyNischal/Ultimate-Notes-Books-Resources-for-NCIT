import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintProgram extends JFrame implements MouseListener, MouseMotionListener {
    private int x, y;
    private boolean painting = false;

    public PaintProgram() {
        setTitle("Paint Program");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    // If Mouse is Pressed start drawing 
    public void mousePressed(MouseEvent e) {
        painting = true;
        x = e.getX();
        y = e.getY();
// the repaint() method is being called to request a redraw of  the component whenever 
// the mouse is pressed or released, or when it is being dragged
        repaint();
    }
    // If mouse is released stop drawing 
    public void mouseReleased(MouseEvent e) {
        painting = false;
        repaint();
    }
    // Draw inside frame if mouse is dragged
    public void mouseDragged(MouseEvent e) {
        if (painting) {
            x = e.getX();
            y = e.getY();
            repaint();
        }
    }
    public void mouseMoved(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    public void paint(Graphics g) {
        if (painting) {
            // g.drawLine(x,y, x, y);
            g.drawString("PRADIP", x, y);
        }
    }

    public static void main(String[] args) {
        new PaintProgram();
        
    }
}

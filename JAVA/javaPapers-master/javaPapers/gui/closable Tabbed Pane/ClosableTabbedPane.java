
package com.obs.gui.swing.interfaces;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class ClosableTabbedPane extends JTabbedPane implements MouseListener {

  public ClosableTabbedPane() {
    super();
    addMouseListener(this);
  }


  public void addTab(String title, Component component) {
    this.addTab(title, component, null);
  }


  public void addTab(String title, Component component, Icon extraIcon) {
    super.addTab(title, new CloseTabIcon(extraIcon), component);
  }


  public void mouseClicked(MouseEvent e) {
    int tabNumber=getUI().tabForCoordinate(this, e.getX(), e.getY());
    
    if (tabNumber < 0)
        return;
        
    Rectangle rect=((CloseTabIcon)getIconAt(tabNumber)).getBounds();
    
    if (rect.contains(e.getX(), e.getY())) {
      //the tab is being closed
      this.removeTabAt(tabNumber);
    }

  }


  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}

}



class CloseTabIcon implements Icon {
  private int x_pos;
  private int y_pos;
  private int width;
  private int height;
  private Icon fileIcon;

  public CloseTabIcon(Icon fileIcon) {
    this.fileIcon=fileIcon;
    width=16;
    height=16;
  }


  public void paintIcon(Component c, Graphics g, int x, int y) {
    this.x_pos=x;
    this.y_pos=y;
    Color col=g.getColor();
    g.setColor(Color.black);
    int y_p=y+2;
    g.drawLine(x+1, y_p, x+12, y_p);
    g.drawLine(x+1, y_p+13, x+12, y_p+13);
    g.drawLine(x, y_p+1, x, y_p+12);
    g.drawLine(x+13, y_p+1, x+13, y_p+12);
    g.drawLine(x+3, y_p+3, x+10, y_p+10);
    g.drawLine(x+3, y_p+4, x+9, y_p+10);
    g.drawLine(x+4, y_p+3, x+10, y_p+9);
    g.drawLine(x+10, y_p+3, x+3, y_p+10);
    g.drawLine(x+10, y_p+4, x+4, y_p+10);
    g.drawLine(x+9, y_p+3, x+3, y_p+9);
    g.setColor(col);
    if (fileIcon != null) {
      fileIcon.paintIcon(c, g, x+width, y_p);
    }
  }


  public int getIconWidth() {
    return width + (fileIcon != null? fileIcon.getIconWidth() : 0);
  }


  public int getIconHeight() {
    return height;
  }


  public Rectangle getBounds() {
    return new Rectangle(x_pos, y_pos, width, height);
  }

}

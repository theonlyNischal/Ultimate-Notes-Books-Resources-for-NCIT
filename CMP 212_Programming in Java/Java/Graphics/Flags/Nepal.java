//  Because I didn't draw the blue outlines and the figure
//  "CHANDRA" and "SURYA," this isn't the authentic Nepal flag.
//  Therefore, if you also do this in the exam, you will receive full marks. 
// The real flag code will also be included somewhere in this repo.

import javax.swing.*;
import java.awt.*;

public class Nepal extends JFrame {
  public  Nepal(){
            setSize(500,500);
            setVisible(true);
    }
    public void paint(Graphics g){

        // for first triangle

        int [] x ={100,200,100};
        int [] y1 ={50,100,150};
        g.setColor(Color.red);
        g.fillPolygon(x,y1,3);

        // For 2nd Triangle

        int [] y2 ={150,200,250};
        g.setColor(Color.red);
        g.fillPolygon(x,y2,3);

        // For the pole of flag
        g.setColor(Color.black);
        g.drawLine(100,50,100,300);
    }
    public static void main(String []args){
        new Nepal();
    }
}


// FLAG OF NEPAL

import javax.swing.*;
import java.awt.*;

public class Nepal extends JFrame {
    static Color NEPALIFLAG = new Color(221,12,39);
public  Nepal(){
            setSize(500,500);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
    }
    public void paint(Graphics g){
       
        // for Upper triangle

        int [] UpperTriangleX ={210,360,210};
        int [] UpperTriangleY ={20,160,160};

        Polygon UpperTriangle = new Polygon(UpperTriangleX,UpperTriangleY,3);
        g.drawPolygon(UpperTriangle);
        g.setColor(NEPALIFLAG);
        g.fillPolygon(UpperTriangle);

        // For lower Triangle
        int [] LowerTriangleX ={210,390,210};
        int [] LowerTriangleY ={160,340,340};

        Polygon LowerTriangle = new Polygon(LowerTriangleX,LowerTriangleY,3);
        g.drawPolygon(LowerTriangle);
        g.setColor(NEPALIFLAG);
        g.fillPolygon(LowerTriangle);

        // For Stick of the Flag
        int [] StickX ={207,210,210,207};
        int [] StickY ={7,7,500,498};

        Polygon Stick = new Polygon(StickX,StickY,4);
        g.drawPolygon(Stick);
        g.setColor(Color.black);
        g.fillPolygon(Stick);

        // For Borders
        int [] BorderX ={210,210,360,210,390,210,210,396,216,366};
        int [] BorderY ={17,20,160,160,340,340,343,343,163,163};

        Polygon Border = new Polygon(BorderX,BorderY,10);
        g.drawPolygon(Border);
        g.setColor(Color.blue);

        // Flag Border using fill Polygon
        g.fillPolygon(Border);

        // For Moon
        g.setColor(Color.white);
        g.fillOval(240,100,30,30);
        g.setColor(NEPALIFLAG);
        g.fillOval(240,91,30,30);

        // For Star
        int [] StarX ={240,250,255,260,270,265,270,260,255,250,240,245};
        int [] StarY ={260,260,250,260,260,270,280,280,290,280,280,270};

        Polygon Star = new Polygon(StarX,StarY,12);

        // flag.drawPolygon is Used

        g.drawPolygon(Star);
        g.setColor(Color.white);
        g.fillPolygon(Star);
    }
    public static void main(String []args){
        new Nepal();
    }
}


// Created By Pradip Dhungana
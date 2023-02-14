// In a class of 48 students, 20 of them aspire to become a web developer,
// 12 prefer to become a mobile app developer, 10 want to pursue a career in
// game development and the remaining wants to become a data scientist.
// Illustrate this data in a pie chart.

import javax.swing.*;
import java.awt.*;

public class PieChart extends JFrame{
    final int [] data = {20,12,10,6};
    final int frame_height = 800;
    final int frame_width = 800;

    public PieChart(){
        setSize(frame_width,frame_height);
        setVisible(true);
    }

    public int getSum(){
        int sum = 0;
        for(int i:data){
            sum += i;
        }
        return sum;
    }

    public int[] getAngles(){
        int sum = getSum();
        int[] angles = new int[data.length];
        for(int i=0;i<data.length;i++){
            angles[i] = (int) (360 * data[i] / sum);
        }
        return angles;
    }

    public void paint(Graphics g){
        int startAngle = 0;
        int[] angles = getAngles();
        Color [] colors = {Color.red,Color.black,Color.green,Color.pink};
        for(int i=0;i<data.length;i++){
            g.setColor(colors[i]);
            g.fillArc(300,400,400,400,startAngle, angles[i]);

            startAngle += angles[i];
        }
    }

    public static void main(String []args){
        new PieChart();
    }
}

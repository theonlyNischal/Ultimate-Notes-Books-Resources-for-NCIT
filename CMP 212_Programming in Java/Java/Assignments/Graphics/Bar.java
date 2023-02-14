// In a class of 48 students, 20 of them aspire to become a web developer,
// 12 prefer to become a mobile app developer, 10 want to pursue a career in
// game development and the remaining wants to become a data scientist.
// Illustrate this data in a bar diagram.

import javax.swing.*;
import java.awt.*;

public class Bar extends JFrame{
    final int [] data = {20,12,10,6};
    final int frame_height = 800;
    final int frame_width = 800;
    final int bar_width = 200;

    public Bar(){
        setSize(frame_width,frame_height);
        setVisible(true);
    }
    public int getMax(){
        int max = 0;
        for(int i:data){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
    public int [] transformData(){
        int [] tb = new int [data.length];
        int max_height = 700;
        int max = getMax();
        for(int i=0;i<data.length;i++){
            tb [i] = Math.round((max_height * data[i]) / max);
        }
        return tb;
    }
    public void paint(Graphics g){
        Color [] colors = {Color.red,Color.black,Color.green,Color.pink};
        int [] td = transformData();
        for(int i=0;i<td.length;i++){
            g.setColor(colors[i]);
            g.fillRect(i*bar_width,frame_height-td[i], bar_width,td[i]);
        }
    }
    public static void main(String []args){
        new Bar();
    }
}

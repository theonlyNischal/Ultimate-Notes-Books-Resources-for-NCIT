import javax.swing.*;
import java.awt.*;

public class Italy extends JFrame{
   public Italy(){
            setSize(500,500);
            setVisible(true);
    }
    public void paint(Graphics g){
        final int x = 100;
        final int y = 100;
        final int width = 100;
        final int height = 200;

        Color [] colors = {Color.green,Color.white,Color.red};

        for(int i=0;i<3;i++){
            g.setColor(colors[i]);

            // As italy flag has vertical rectangular stripes the x values changes and y value remain still.

            g.fillRect(x+(i*width),y,width,height);
        }
    }
    public static void main(String []args){
        new Italy();
    }
}

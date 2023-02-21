import javax.swing.*;
import java.awt.*;
public class German extends JFrame {
    public German(){
        setSize(500,500);
        setVisible(true);
    }
    public void paint(Graphics g){
        final int x = 100;
        final int y = 100;
        final int width = 350;
        final int height = 100;

        Color [] colors = {Color.BLACK,Color.RED,Color.YELLOW};

        for(int i=0;i<3;i++){
            g.setColor(colors[i]);

            g.fillRect(x,y+(i*height),width,height);
        }

    }
    public static void main(String [] args){
        new German();
    }
}

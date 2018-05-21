//creating a JSlider
import javax.swing.*;  
import java.awt.*;
   
 public class SliderExample extends JFrame{  
   
 public SliderExample() {  
   
 JSlider slider = new JSlider();//JSlider.HORIZONTAL, 0, 50, 25);  
 slider.setMinorTickSpacing(2);  
 slider.setMajorTickSpacing(10);  
   
 slider.setPaintTicks(true);  
 slider.setPaintLabels(true);  
 //slider.setInverted(true);
   
 setLayout(new FlowLayout());  
 add(slider);  
 }  
   
 public static void main(String s[]) {  
 SliderExample frame=new SliderExample();  
 frame.pack();  
 frame.setVisible(true);  
}  
}  

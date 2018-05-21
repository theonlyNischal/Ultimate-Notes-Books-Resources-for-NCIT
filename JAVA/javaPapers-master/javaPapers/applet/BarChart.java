package applet;
import java.applet.*;
import java.awt.*;

public class BarChart extends Applet
{
 int n=5;
 String year[]={"2001","2002","2003","2004","2005"};
 int value[]={80,50,100,65,90};

  public void paint(Graphics g)
 {
  for(int i  = 0; i < n; i++)
  {
   g.setColor(Color.BLUE);
   g.drawString(year[i], 20, i * 50 + 30);
   g.setColor(Color.RED);
   g.fillRect(70, i * 50 + 10, value[i], 40);
   g.drawString(value[i]+ "%", 180, i * 50 + 35);
  }

  String msg = "Bar Chart from Year 2001 - 2005";
  g.setColor(Color.darkGray);
  g.drawString(msg, 50, 300);
 }
}
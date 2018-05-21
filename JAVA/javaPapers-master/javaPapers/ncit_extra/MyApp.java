import java.applet.*;
import java.awt.*;
public class MyApp extends Applet
{
  public void paint(Graphics g)
  {
   
   
    //g.setColor(Color.RED);
    //g.drawOval(10,20,200,200);
    //g.drawOval(20,30,30,30);
   // g.fillArc(10,10,200,200,0,30);
    
    Polygon poly=new Polygon();
    poly.addPoint(100,10);
    poly.addPoint(200,200);
    poly.addPoint(10,200);
    g.drawPolygon(poly);
  }
}
import java.awt.*;
import java.applet.*;

class DrawShapes extends Applet
{
 public void paint(Graphics g)
 {
  Polygon poly=new Polygon();
  poly.addPoint(1,1);
  poly.addPoint(100,100);
  poly.addPoint(100,1);
  g.fillPolygon(poly);
 }
}
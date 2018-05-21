import java.awt.*;
import java.applet.*;

 public class PassParam extends Applet
{
  String msg="";
  public void start()
  {
  msg=getParameter("msg"); 
  }
  public void paint(Graphics g)
  {
   g.drawString(msg,10,10);
  }
    
}
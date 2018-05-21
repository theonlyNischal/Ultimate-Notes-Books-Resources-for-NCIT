import java.applet.*;
import java.awt.*;

/*
<applet code = "BarChart.class" width=400 height=400>

<param name="year0" value="2001">
<param name="year1" value="2002">
<param name="year2" value="2003">
<param name="year3" value="2004">
<param name="year4" value="2005">

<param name="result0" value="80">
<param name="result1" value="90">
<param name="result2" value="100">
<param name="result3" value="100">
<param name="result4" value="98">

</applet>
*/

public class BarChart extends Applet
{
 int n;
 String year[];
 int value[];

 public void init()
 {
  n = 5;
  year = new String[n];
  value = new int[n];

  year[0] = getParameter("year0");
  year[1] = getParameter("year1");
  year[2] = getParameter("year2");
  year[3] = getParameter("year3");
  year[4] = getParameter("year4");

  value[0] = Integer.parseInt(getParameter("result0"));
  value[1] = Integer.parseInt(getParameter("result1"));
  value[2] = Integer.parseInt(getParameter("result2"));
  value[3] = Integer.parseInt(getParameter("result3"));
  value[4] = Integer.parseInt(getParameter("result4"));

 }

 public void paint(Graphics g)
 {
  Font font = new Font("Arial",Font.BOLD,15);
  g.setFont(font);
  for(int i  = 0; i < n; i ++)
  {
   g.setColor(Color.BLUE);
   g.drawString(year[i], 20, i * 50 + 30);
   g.setColor(Color.RED);
   g.fillRect(70, i * 50 + 10, value[i], 40);
   g.drawString(String.valueOf(value[i]) + "%", 180, i * 50 + 35);
  }

  String msg = "Bar Chart from Year 2001 - 2005";
  g.setColor(Color.darkGray);

  font = new Font("Arial",Font.BOLD,20);
  g.setFont(font);
  g.drawString(msg, 50, 300);
 }
}
import java.applet.Applet;
import java.awt.*;

public class HelloApplet extends Applet {
public void init(){
System.out.println("Init");

}//init
public void start(){
System.out.println("start");

}//start

public void stop(){
System.out.println("stop");

}//stop
public void destroy(){
System.out.println("destroy");

}//destroy
public void paint(Graphics g){
System.out.println("Paint");

}//start


} //HelloApplet
/*
<applet code="HelloApplet.class" width="400" height="400">
</applet>
*/
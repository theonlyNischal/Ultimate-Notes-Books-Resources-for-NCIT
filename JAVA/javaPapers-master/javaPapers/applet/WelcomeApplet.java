import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeApplet extends Applet implements ActionListener
{
   Button b1;
   TextField t1,t2,t3;
   
   public void init(){
	b1=new Button("click me");
        t1=new TextField(10);
        t2=new TextField(10);	
	t3=new TextField(10);
        
        add(t1);
        add(t2);
	add(t3);
        add(b1);

	b1.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e){
   	if(e.getSource()==b1){
		int num1=Integer.parseInt(t1.getText());
		int num2=Integer.parseInt(t2.getText());
		int num3=num1+num2;
		t3.setText(num3+"");
	}
   }
  
}
import java.awt.*;
class GUI2
{
  GUI2()
  {
    Frame f=new Frame();
    Button b=new Button("Click Me");
    b.setBounds(30,50,100,30);
    f.add(b);
    f.setLayout(null);
    f.setSize(200,200);
    f.setVisible(true);
  //  f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
  }
  public static void main(String args[])
  {
    new GUI2();
  }
}
    
    
    
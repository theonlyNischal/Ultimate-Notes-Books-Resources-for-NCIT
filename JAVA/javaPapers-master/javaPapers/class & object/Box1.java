//returning object 
class Box1
{
  double length,breadth,height;
  
  Box1 setDim(double l,double b, double h)
  {
    Box1 ob=new Box1();
    ob.length=l;
    ob.breadth=b;
    ob.height=h;
    
    return ob;
  }
 
  double volume()
  {
    return length*breadth*height;
  }
}
class BoxDemo1
{
  public static void main(String args[])
  {
    Box1 b1=new Box1();
    Box1 b2=new Box1();
    b2=b1.setDim(4,3,2);
    System.out.println("Volume: "+b1.volume());
    System.out.println("Volume: "+b2.volume());
  }
}
      
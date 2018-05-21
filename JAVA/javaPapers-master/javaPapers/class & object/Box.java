//passing object as argument
class Box
{
  double length,breadth,height;
  
  void setDim(double l,double b,double h)
  {
    length=l;
    breadth=b;
    height=h;
  }
  void setDim(Box ob)
  {
    length=ob.length;
    breadth=ob.breadth;
    height=ob.height;
  }
  double volume()
  {
    return length*breadth*height;
  }
}
class BoxDemo
{
  public static void main(String args[])
  {
    Box b1=null;//=new Box();
    b1.setDim(4,3,2);
    System.out.println("Volume: "+b1.volume());
    
    Box b2=new Box();
    b2.setDim(b1);
    System.out.println("Volume: "+b2.volume());
  }
}
      
//method overloading
class Room
{
  double length,breadth;
  
  void setDim()
  {
    length=5;
    breadth=2;
  }
  void setDim(double l)
  {
    length=l;
    breadth=3;
  }
  void setDim(double l, double b)
  {
    length=l;
    breadth=b;
  }
  
  void area()
  {
    System.out.println("Area: "+ length*breadth);
  }
}
class RoomDemo
{
  public static void main(String args[])
  {
    Room r[]=new Room[3];
    r[0]=new Room();
    r[1]=new Room();
    r[2]=new Room();
    
    r[0].setDim();
    r[0].area();
    
    r[1].setDim(2);
    r[1].area();
    
    r[2].setDim(3,4);
    r[2].area();
    
  }
}
    
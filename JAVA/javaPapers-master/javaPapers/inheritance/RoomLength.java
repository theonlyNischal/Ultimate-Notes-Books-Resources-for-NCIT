class RoomLength
{
  double length;
  
  RoomLength(double l)
  {
    length=l;
  }
}
class RoomBreadth extends RoomLength
{
  double breadth;
  RoomBreadth(double l, double b)
  {
     super(l);
     breadth=b;
  }
  void area()
  {
    System.out.println("Area is : "+length*breadth);
  }
}
class SingleInheritance
{
  public static void main(String args[])
  {
    RoomBreadth b=new RoomBreadth(4.3,3.2);
    b.area();
  }
}
                    
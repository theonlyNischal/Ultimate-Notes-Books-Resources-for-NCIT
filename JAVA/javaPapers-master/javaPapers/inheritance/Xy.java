//using super to call base class constructor
class Xy
{
  int length;
  Xy(int l)
  {
    length=l;
  }
  final void check()
  {
    System.out.println("inside check:");
  }
}
class Yz extends Xy
{
  int breadth;
  Yz(int l,int b)
  {
    super(l);
    breadth=b;
  }
  void area()
  {
    int a=length*breadth;
    System.out.println("Area: "+a);
  }
}
class xx
{
  public static void main(String args[])
  {
    Yz ob=new Yz(3,2);
    ob.area();
    ob.check();
  }
}
  
  
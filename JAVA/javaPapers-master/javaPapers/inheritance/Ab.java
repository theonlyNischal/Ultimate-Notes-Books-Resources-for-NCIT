class Ab
{
  int i;
}
class Ba extends Ab
{
  int i;
  Ba(int a, int b)
  {
    super.i=a;
    i=b;
  }
  void show()
  {
    System.out.println("i in superclass: "+super.i);
    System.out.println("i in subclass: "+i);
  }
}
class Check
{
  public static void main(String args[])
  {
    Ba ob=new Ba(3,4);
    ob.show();
  }
}
                         
  
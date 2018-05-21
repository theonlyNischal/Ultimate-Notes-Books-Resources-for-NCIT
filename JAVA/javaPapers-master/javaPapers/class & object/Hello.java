class Hello
{
  int num;
  double num1;
  
  void setVal(int n)
  {
    num=n;
  }
  
  void setVal(double n)
  {
    num1=n;
  }
  
  void showVal()
  {
    System.out.println(num1);
    System.out.println(num);
  }
}

class Heeel
{
  public static void main(String ars[])
  {
    Hello h=new Hello();
    h.setVal(10);
    h.setVal(2.4);
    h.showVal();
  }
}
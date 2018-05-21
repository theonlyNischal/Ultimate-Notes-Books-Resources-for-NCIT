class MultiCatch
{
  public static void main(String args[])
  {
    try
    {
      int a=args.length;
      int b=10/a;
      System.out.println(b);
      int c[]={1,2,3,4,5};
      c[5]=20;
      System.out.println(c[10]);
    }
    catch(ArithmeticException e)
    {
      System.out.println(e);
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      System.out.println(e);
    }
    System.out.println("After try/catch");
  }
}
class Divisible
{
  static int isDivisible(int []a, int div)
  {
    int ret=1;
    for(int m:a)
    {
      if(m%div!=0)
        ret=0;
    }
    return ret;
  }
  public static void main(String args[])
  {
    int a[]={};
    int x=isDivisible(a,3);
    System.out.println(x);
  }
}
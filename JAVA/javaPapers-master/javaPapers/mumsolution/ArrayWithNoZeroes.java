class ArrayWithNoZeroes
{
  static int arrayHasNoZeroes(int []a)
  {
    int ret=1;
    for(int m:a)
    {
      if(m==0)
      {
        ret=0;
        break;
      }
    }
    return ret;
  }
  public static void main(String args[])
  {
    int a[]={};
    int x=arrayHasNoZeroes(a);
    System.out.println(x);
  }
}
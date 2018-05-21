class StackedNumber
{
  static int isStacked(int n)
  {
    int ret=0,s=0;
    for(int i=1;i<=n/2;i++)
    {
      s+=i;
      if(s==n)
      {
        ret=1;
        break;
      }
    }
      
    return ret;
  }
  public static void main(String args[])
  {
    int x=isStacked(45);
    System.out.println(x);
  }
}
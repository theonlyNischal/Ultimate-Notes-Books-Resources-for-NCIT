class Isolated
{
  static int isIsolated(long n)
  {
    int ret=0;
    long sqr=n*n, cube=sqr*n;
    while(sqr!=0)
    {
      int r1=(int)sqr%10;
      while(cube!=0)
      {
        int r2=(int)cube%10;
        if(r1==r2)
        {
          ret=1;
          break;
        }
        else
          cube=cube/10;
      }
      if(ret==1)break;
      else
        sqr=sqr/10;
        
    }
    return ret;
  }
  public static void main(String args[])
  {
    int x=isIsolated(60);
    System.out.println(x);
  }
}
  
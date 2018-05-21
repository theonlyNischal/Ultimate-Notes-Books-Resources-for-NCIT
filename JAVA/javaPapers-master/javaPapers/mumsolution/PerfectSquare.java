class PerfectSquare
{
  static int nextPerfectSquare(int n)
  {
    int i=0,c=0;
    boolean flag=true;
    while(flag)
    {
      c=i*i;
      if(c<=n)
      {
        i+=1;
      }
      else
      {
        flag=false;
      }
    }
    return c;
  }
  public static void main(String args[])
  {
    int check=nextPerfectSquare(36);
    System.out.println(check);
  }
}
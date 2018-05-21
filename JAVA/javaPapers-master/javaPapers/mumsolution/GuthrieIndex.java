class GuthrieIndex
{
  static int guthrieIndex(int n)
  {
    int ret=0;
    if(n<=1)
      return 0;
    else
    {
      while(n!=1)
      {
        if(n%2==0)
          n=n/2;
        else
          n=n*3+1;
        ret++;
      }
    }
     return ret; 
  }
  public static void main(String args[])
  {
    int x=guthrieIndex(3);
    System.out.println(x);
  }
}
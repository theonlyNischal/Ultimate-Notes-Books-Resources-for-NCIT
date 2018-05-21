class Trivalent
{
  static int isTrivalent(int []a)
  {
    int ret=1,count=0;
    int m,n,o=0;
    for(int w:a)
    {
      m=w;
      if(m
    }
    return ret;
  }
  public static void main(String args[])
  {
    int []a={1,2,1,3,2,1,3};
    int x=isTrivalent(a);
    System.out.println(x);
  }
}
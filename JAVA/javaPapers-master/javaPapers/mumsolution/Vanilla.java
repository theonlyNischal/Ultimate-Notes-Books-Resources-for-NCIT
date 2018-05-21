class Vanilla
{
  static int isVanilla(int []a)
  {
    int ret=1;
    if(a.length==0)
      return 1;
    else{
      int check=a[0]%10;
    for(int m:a)
    {
      while(m!=0)
      {
        int r=m%10;
        int checknegative=r+check;
        if(r!=check && checknegative!=0)
        {
          ret=0;
          break;
        }
        m=m/10;
      }
    }
    }
    return ret;
  }
  public static void main(String args[])
  {
    int a[]={};
    int x=isVanilla(a);
    System.out.println(x);
  }
}
    
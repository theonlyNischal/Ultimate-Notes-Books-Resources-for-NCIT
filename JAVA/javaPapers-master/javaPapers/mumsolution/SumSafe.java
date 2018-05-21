class SumSafe
{
  static int isSumSafe(int []a)
  {
    int ret=1,s=0;
    if(a.length==0)
      return 0;
    else{
    for(int m:a)
        s+=m;
    for(int m:a)
    {
      if(s==m)
      {  ret=0;break;}
    }
    }
    return ret;
    
  }
  public static void main(String args[])
  {
    int a[]={};
    int x=isSumSafe(a);
    System.out.println(x);
  }
}
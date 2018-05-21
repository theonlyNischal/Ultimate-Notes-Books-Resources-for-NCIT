class SumFactor
{
  static int sumFactor(int []a)
  {
    int s=0,count=0;
    for(int m:a)
      s+=m;
    for(int n:a)
    {
      if(s==n)
        count++;
    }
    return count;
    
  }
  public static void main(String args[])
  {
    int a[]={};
    int x=sumFactor(a);
    System.out.println(x);
  }
}
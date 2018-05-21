class NUnique
{
  static int isNUnique(int []a,int n)
  {
    int count=0,x=0;
    for(int i=0;i<a.length-1;i++)
    {
      int s=0;
      for(int j=i+1;j<a.length;j++)
      {
        s=a[i]+a[j];
        if(s==n)
          count++;
      }
    }
    if(count==1)
      x=1;
    return x;
  }
  public static void main(String args[])
  {
    int []a={1};
    int x=isNUnique(a,0);
    System.out.println(x);
  }
}
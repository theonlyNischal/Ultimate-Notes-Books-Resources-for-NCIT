class NUpCount
{
  static int nUpCount(int[]a,int n)
  {
    int x=0,psum=0;
    for(int m:a)
    {
      int prevSum=psum;
      psum=psum+m;
      if(prevSum<n && psum>=n)
      {
        x+=1;
      }
    }
    
    return x;
     
  }
  public static void main(String args[])
  {
    int m[]={2,3,1,-6,8,-3,-1,2};
    int x=nUpCount(m,5);
    
    int n[]={1,2,-1,5,3,2,-3};
    int y=nUpCount(n,20);
    System.out.println(x);
    System.out.println(y);
  }
}
class RepsEqual
{
  static int repsEqual(int []a,int n)
  {
    int ret=0,sumArray=0;
    int i=a.length;
    
    for(int m:a)
    {
      if(i>=0){
      sumArray+=m*(Math.pow(10,i));
      i--;
      }
    }
    
    if(sumArray==n)
      ret=1;
    
    return ret;
  }
  public static void main(String args[])
  {
    int a[]={3,2,0,5,3};
    int x=repsEqual(a,32053);
    System.out.println(x);
  }
}
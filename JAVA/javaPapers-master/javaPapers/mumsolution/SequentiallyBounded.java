//not correct. need to make some corrections

class SequentiallyBounded
{
  static int isSequentiallyBounded(int []a)
  {
    int ret=1;
    for(int m:a)
    {
      int count=0;
      for(int n:a)
      {
        if(m>n)
        {
          ret=0;
          break;
        }
        if(m==n)
        {
          count++;
        }
      }
      if(count<m && ret!=0)
      {
        ret=1;
      }
    
    }
    return ret;
  }
  public static void main(String args[])
  {
    int []a={2,3,3,4,4,4};
    int x=isSequentiallyBounded(a);
    System.out.println(x);
  }
}
class PrimeCount
{
  static int primeCount(int start, int end)
  {
    int count=0;
    /*while(start<=end)
    {
      if(start<=1)
        start++;
      else{
      boolean isPrime=true;
      for(int i=2;i<=start/2;i++)
      {
        if(start%i==0)
        {
          isPrime=false;
          break;
        }
      }
      if(isPrime==true)
      {
        count++;
      }
      start++;
    }
    }*/
    
    for(int m=start;m<=end;m++)
    {
      if(m<=1)
        m++;
      else{
      boolean isPrime=true;
      for(int i=2;i<=m/2;i++)
      {
        if(m%i==0)
        {
          isPrime=false;
          break;
        }
      }
      if(isPrime==true)
        count++;
    }
    }
    return count;
  }
  public static void main(String args[])
  {
    int count=primeCount(-10,6);
    System.out.println(count);
  }
}
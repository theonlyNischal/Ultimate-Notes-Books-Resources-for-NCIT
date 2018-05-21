class StantonMeasure
{
  static int stantonMeasure(int []a)
  {
    int count=0,stanton=0;
    for(int i:a)
    {
      if(i==1)
        count++;
    }
    for(int m:a)
    {
      if(m==count)
        stanton++;
    }
    return stanton;    
        
  }
  public static void main(String args[])
  {
    int a[]={};
    int x=stantonMeasure(a);
    System.out.println(x);
  }
}
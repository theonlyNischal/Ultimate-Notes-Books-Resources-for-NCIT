class ConvertToBase10
{
  static int isLegalNumber(int []a,int b)
  {
    int x=0;
    for(int m:a)
    {
      if(m>=b)
      {
        x=1;
        break;
      }
    }
    return x;
  }
  
  static int convertToBase10(int []a, int base)
  {
    int num=0,p=0;
    int check=isLegalNumber(a,base);
    if(check==0)
    {
      for(int i=a.length-1;i>=0;i--)
      {
        num+=a[i]*Math.pow(base,p);
        p++;
      }
    }
    return num;
  }
  public static void main(String args[])
  {
    int a[]={3, 7, 1};
    int num=convertToBase10(a,6);
    System.out.println(num);
  }
}
class GuthrieSequence
{
  static int isGuthrieSequence(int []a)
  {
    int c=0;
    int len=a.length;
    if(a[len-1]!=1)
      c=0;
    else
    {
      int x=a[0];
      int m;
      for(int i=1;i<len;i++)
      {
        if(x%2==0)
           m=x/2;
        else
           m=x*3+1;
        
        if(m!=a[i]){c=0;break;}
        else{x=a[i];c=1;}
       }
     }
    return c;
      
  }
  public static void main(String args[])
  {
    int a[]={22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1};
    int x=isGuthrieSequence(a);
    System.out.println(x);
      
  }
}
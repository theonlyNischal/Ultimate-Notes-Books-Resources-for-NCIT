class Sum_Array
{
  public static void main(String args[])
  {
    int a[][]={{2,2},{3,4}};
    int b[][]={{3,7},{-1,4}};
    
    int c[][]=new int[2][2];
    for(int i=0;i<2;i++)
    {
      for(int j=0;j<2;j++)
      {
        int sum=0;
        for(int k=0;k<2;k++)
        {
          sum=sum+a[i][k]*b[k][j];
        }
        c[i][j]=sum;
      }
    }
    
    for(int i=0;i<2;i++)
    {
      for(int j=0;j<2;j++)
      {
        System.out.print(c[i][j]+"\t");
      }
      System.out.println();
    }
  }
}
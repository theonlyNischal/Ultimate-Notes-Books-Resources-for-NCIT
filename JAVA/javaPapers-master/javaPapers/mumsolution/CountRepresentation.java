class CountRepresentation
{
  static int countRepresentation(int numRupees)
  {
    int count=0;
    for(int rupee20=0;rupee20<=numRupees;rupee20++)
       for(int rupee10=0;rupee10<=rupee20;rupee10++)
        for(int rupee5=0;rupee5<=rupee10/2;rupee5++)
          for(int rupee2=0;rupee2<=rupee5/2;rupee2++)
      for(int rupee1=0;rupee1<=rupee2;rupee1++){
     
      int s=rupee1+rupee2+rupee5+rupee10+rupee20;
      if(s==numRupees)
        count++;
    }
     
    
    return count;
    
  }
  public static void main(String args[])
  {
    int c=countRepresentation(6);
    System.out.println(c);
  }
}
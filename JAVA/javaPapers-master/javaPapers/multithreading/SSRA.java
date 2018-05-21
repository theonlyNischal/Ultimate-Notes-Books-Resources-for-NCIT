class SSRA extends Thread
{
  public void run()
  {
    try
    {
      for(int i=1;i<=10;i++)
      {
        System.out.println("i= "+i);
        Thread.sleep(500);
      }
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
  }
}


class SSRB extends Thread
{ int j;
  public void run()
  {
    try
    {
      for( j=1;j<=10;j++)
      {
        System.out.println("j= "+j);
        Thread.sleep(1000);
      }
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
  }
}

class StopSuspend
{
  public static void main(String args[])
  {
    SSRA ob1=new SSRA();
    SSRB ob2=new SSRB();
    ob1.start();
   
    
    System.out.println("Suspending thread one");
    ob1.suspend();
    
     ob2.start();
    ob2.yield();
    System.out.println("Resuming thread one");
    
    ob1.resume();
   
  }
}
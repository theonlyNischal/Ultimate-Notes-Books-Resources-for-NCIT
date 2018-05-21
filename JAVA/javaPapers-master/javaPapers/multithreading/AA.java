class AA implements Runnable
{
  public void run() 
  {
    try
    {
      for(int i=1;i<=5;i++)
      {
        System.out.println("i="+i);
        Thread.sleep(1000);
      }
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
  }
}

class BB implements Runnable
{
  public void run()
  {
    try
    {
      for(int j=1;j<=5;j++)
      {
        System.out.println("j="+j);
        Thread.sleep(1000);
      }
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
  }
}


class ThreadDemo1
{
  public static void main(String args[])
  {
    //new Thread(new AA()).start();
    //new Thread(new BB()).start();
   //System.out.println("Main Thread Exiting");
    AA ob1=new AA();
    Thread t1=new Thread(ob1);
    t1.start();
    BB ob2=new BB();
    Thread t2=new Thread(ob2);
    t2.start();
  }
}


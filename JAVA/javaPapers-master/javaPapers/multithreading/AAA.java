class AAA extends Thread
{
  public void run()
  {
    try
    {
      for(int i=1;i<=5;i++)
      {
        System.out.println("i="+i);
        Thread.sleep(100);
      }
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
  }
}

class BBB extends Thread
{
  public void run()
  {
    try
    {
      for(int j=1;j<=5;j++)
      {
        System.out.println("j="+j);
        Thread.sleep(100);
      }
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
  }
}


class ThreadDemo2
{
  public static void main(String args[])
  {
   A ob1=new A();
   B ob2=new B();
   
   ob1.setName("One");
   ob2.setName("Two");
   
   System.out.println("Thread "+ob1.getName()+" is starting....");
   System.out.println("Thread "+ob2.getName()+" is starting....");
   
   ob1.start();
   ob2.start();
   
   System.out.println(ob1.isAlive());
   System.out.println(ob2.isAlive());
   
   try
   {
     ob1.join();
     ob2.join();
   }
   catch(InterruptedException e)
   {
     System.out.println(e);
   }
   
   System.out.println(ob1.isAlive());
   System.out.println(ob2.isAlive());
   
   
   
     System.out.println("Main Thread Exiting");
  }
}


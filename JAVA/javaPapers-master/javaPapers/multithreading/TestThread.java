class TestThread
{
 
  
  public static void main(String args[])
  {
     Object lock1=new Object();
     Object lock2=new Object();
     
    ThreadDemo1 t1=new ThreadDemo1(lock1,lock2);
    ThreadDemo2 t2=new ThreadDemo2(lock1,lock2);
    
    t1.start();
    t2.start();
  }
}

class ThreadDemo1 extends Thread
{
  Object lock1,lock2;
  ThreadDemo1(Object lock, Object l)
  {
    lock1=lock;
    lock2=l;
  }
    
  public void run()
  {
    synchronized(lock1)
    {
      System.out.println("Thread one holding lock1");
      try
      {
        Thread.sleep(1000);
      }
      catch(InterruptedException e){}
      System.out.println("Thread one waiting for lock2");
      synchronized(lock2){
        System.out.println("Thread one holding lock1 and lock2");
    }
  }
}
}

 class ThreadDemo2 extends Thread
{
     Object lock1,lock2;
  ThreadDemo2(Object lock, Object l)
  {
    lock1=lock;
    lock2=l;
  }
   public void run()
  {
    synchronized(lock1)
    {
      System.out.println("Thread two holding lock1");
      try
      {
        Thread.sleep(1000);
      }
      catch(InterruptedException e){}
      System.out.println("Thread two waiting for lock2");
      synchronized(lock2){
        System.out.println("Thread two holding lock1 and lock2");
    }
  }
}
}



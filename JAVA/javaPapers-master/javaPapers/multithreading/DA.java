class DA
{
  synchronized void foo(DB b)
  {
    try
    {
      Thread.sleep(10000);
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
    b.last();
  }
  
  synchronized void last()
  {
    System.out.println("DA last");
  }
}


class DB
{
  synchronized void bar(DA a)
  {
    try
    {
      Thread.sleep(10000);
    }
    catch(InterruptedException e)
    {
      System.out.println(e);
    }
    a.last();
  }
  
  synchronized void last()
  {
    System.out.println("DB last");
  }
}


class Deadlock
{
       
     /*  Deadlock()
       {
         Thread t=new Thread(this);
         t.start();
         a.foo(b);
       }*/
         
  public static void main(String args[])
  {
       final DA a=new DA();
       final DB b=new DB();
 
   //new Deadlock();
    Thread t1=new Thread(new Runnable(){
      public void run(){
        a.foo(b);
      }
    });
    Thread t2=new Thread(new Runnable(){
      public void run(){
        b.bar(a);
      }
    });
    t1.start();
    t2.start();
  }
 /*  public void run()
  {
    b.bar(a);
  }*/
}
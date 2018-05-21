class NewThread implements Runnable
{
  Thread t;
  String name;
  NewThread(String n)
  {
   name=n;
    t=new Thread(this,name);
    t.start();
  }
  public void run()
  {
    for(int i=1;i<=10;i++)
    {
      try
      {
        System.out.println("Thread : "+name+"i= "+i);
        Thread.sleep(1000);
      }
      catch(InterruptedException e){}
    }
  }
}

class DemoThread
{
  public static void main(String args[])
  {
    NewThread ob1=new NewThread("one");
    NewThread ob2=new NewThread("two");
    NewThread ob3=new NewThread("three");
    
    System.out.println("Suspending thread one");
    ob1.t.suspend();
     System.out.println("Suspending thread two");
     ob2.t.suspend();
     System.out.println("Resuming Thread one");
     ob1.t.resume();
     System.out.println("Stopping thread three");
     ob3.t.stop();
     System.out.println("Resuming thread two");
     ob2.t.resume();
  }
}
   
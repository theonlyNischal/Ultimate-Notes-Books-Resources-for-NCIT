//synchronization example
class SA extends Thread
{
  BankAccount ba;
  SA(BankAccount ob)
  {
        ba=ob;
  }
  
  public void run()
  {
    synchronized(ba){
    ba.deposit(1000);
  }
  }
}

class SB extends Thread
{
  BankAccount ba;
  SB(BankAccount ob)
  {
    
    ba=ob;
  }
  public void run()
  {
    synchronized(ba){
    ba.deposit(5000);
    }
  }
}

class BankAccount
{
  double balance;
 /* public synchronized void deposit(double amt)
  {
    double newBalance=balance+amt;
    balance=newBalance;
    System.out.println("New Balance: "+balance);
  }*/  
   public void deposit(double amt)
  {
    //double newBalance=balance+amt;
    balance+=amt;
    System.out.println("New Balance: "+balance);
  }
}

class SynchronizedDemo
{
  public static void main(String args[])
  {
    BankAccount ob=new BankAccount();
   SA ob1=new SA(ob);
   SB ob2=new SB(ob);
    
   ob1.start();
   ob2.start();
   
   }
}


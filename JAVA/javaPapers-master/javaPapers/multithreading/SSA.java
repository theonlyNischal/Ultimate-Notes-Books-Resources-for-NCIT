//synchronization static example
class SSA extends Thread
{
    public void run()
  {
    SBankAccount.deposit(1000);
  }
}

class SSB extends Thread
{
  
  public void run()
  {
    SBankAccount.deposit(5000);
  }
}

class SBankAccount
{
  static double balance;
  public static synchronized void deposit(double amt)
  {
    double newBalance=balance+amt;
    balance=newBalance;
    System.out.println("New Balance: "+balance);
  }
}

class SSynchronizedDemo
{
  public static void main(String args[])
  {
   // BankAccount ob=new BankAccount();
   SSA ob1=new SSA();
   SSB ob2=new SSB();
   
  // ob1.setName("One");
  // ob2.setName("Two");
   
  // System.out.println("Thread "+ob1.getName()+" is starting....");
   //System.out.println("Thread "+ob2.getName()+" is starting....");
   
   ob1.start();
   ob2.start();
   
   
     //System.out.println("Main Thread Exiting");
  }
}


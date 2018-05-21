class Account
{
  double balance;
  Account(double b)
  {

    balance=b;
    System.out.println("Account Info: ");

    System.out.println("Balance: "+this.balance);
  }
  public  void deposit(double amt)
  {
    balance+=amt;
      System.out.println("Account Info: After Deposit: ");

    System.out.println("Balance: "+this.balance);

  }
  public  void withdraw(double amt)
  {
    balance-=amt;
     System.out.println("Account Info: After withdraw: ");
   System.out.println("Balance: "+this.balance);
  }
 
}

class DeA extends Thread
{
  Account ob1,ob2;
 
  
  DeA(Account o,Account p)
  {
    this.ob1=o;
    this.ob2=p;
   
  }
  public void run()
  {
    synchronized(ob1){
    try{
    ob1.withdraw(1000);
    Thread.sleep(1000);
    }catch(InterruptedException e){}
    
    synchronized(ob2){
    ob2.deposit(5000);
    }}
}
}


class DeB extends Thread
{
  Account ob1,ob2;
  DeB(Account o,Account p)
  {
    this.ob2=p;
    this.ob1=o;
   
  }
  public void run()
  {synchronized(ob2){  try{
  ob2.withdraw(1000);
  Thread.sleep(1000);
  }catch(InterruptedException e){}
  synchronized(ob1){
  ob1.deposit(5000);
  }}
}
}

class DeadlockDemo
{
  public static void main(String args[])
  {
    Account one=new Account(50000);
    Account two=new Account(30000);
 
    DeA ob1=new DeA(one,two);
    DeB ob2=new DeB(one,two);
    
    ob1.start();
    ob2.start();
  }
}

  
    
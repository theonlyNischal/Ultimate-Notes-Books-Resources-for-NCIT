public class TestClass_SavingsAccount {
    public static void main(String [] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000, 4.00);
        SavingsAccount saver2 = new SavingsAccount(3000, 4.00);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("The Monthly Interest of Saver 1 is: " +saver1.getSavingBalance());
        System.out.println("The Monthly Interest of Saver 2 is: " +saver2.getSavingBalance());

        System.out.println("");

        //The next Month interest New Balance under the updated interest rate
        SavingsAccount.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("The New Monthly Interest Rate for Saver 1 is: " +saver1.getSavingBalance());
        System.out.println("The New Monthly Interest Rate for Saver 2 is: " +saver2.getSavingBalance());


    }
}

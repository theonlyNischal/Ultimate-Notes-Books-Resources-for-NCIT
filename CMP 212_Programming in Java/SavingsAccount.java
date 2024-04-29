/*
This is the Question Number 8 in the assignment regarding static variables
the term static refers The static variable gets memory only once in the class area at the time of class loading.
the test code is named as TestClass_SavingsAccount ( Object Code)
 */
public class SavingsAccount {
    private double SavingBalance;
    private static double annualInterestRate;



    public SavingsAccount(double SavingBalance, double annualInterestRate)
    {
        this.SavingBalance=SavingBalance;
        this.annualInterestRate=annualInterestRate;
    }
    public void calculateMonthlyInterest()
    {
        double MonthlyInterest= (SavingBalance * annualInterestRate)/12;
        SavingBalance=SavingBalance+MonthlyInterest;

    }

    public static void modifyInterestRate(double newAnnualInterestRate)
    {
        annualInterestRate=newAnnualInterestRate;

    }

    public double getSavingBalance()
    {
        return SavingBalance;
    }

}

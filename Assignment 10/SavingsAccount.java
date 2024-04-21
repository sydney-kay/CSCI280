// CS-280 Sp24
// Sydney Nilles
// Assignment 10 - due 04/18/2024

public class SavingsAccount {
    static double annualInterestRate;
    private double savingsBalance;

    // constructor
    // takes in base balance
    public SavingsAccount(double balance){
        savingsBalance = balance;
    }

    // adds the calculated monthly interest to savingsBalance, returns nothing.
    public double calculateMonthlyInterest(){
        double monthlyInterest = (savingsBalance*annualInterestRate/12);
        savingsBalance += monthlyInterest;
        return savingsBalance;
    }

    // sets a new global annualInterestRate value.
    public static void modifyInterestRate(double newRate){
        annualInterestRate = newRate;
    }

}

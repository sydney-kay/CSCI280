// CS-280 Sp24
// Sydney Nilles
// Assignment 10 - due 04/18/2024

public class Main {
    public static void main(String[]args){
        //Instantiating the 2 account objects
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        
        // setting the interest rate to 4%
        SavingsAccount.modifyInterestRate(0.04);
        System.out.println("Savings account 1 now contains: $" + saver1.calculateMonthlyInterest());
        System.out.println("Savings account 2 now contains: $" + saver2.calculateMonthlyInterest());
        
        // spacer text
        System.out.println("==============");

        // setting the interest rate to 5% 
        SavingsAccount.modifyInterestRate(0.05);
        System.out.println("Savings account 1 will contain: $" + saver1.calculateMonthlyInterest());
        System.out.println("Savings account 2 will contain: $" + saver2.calculateMonthlyInterest());
    }
}

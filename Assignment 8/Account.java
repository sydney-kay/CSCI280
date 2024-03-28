// CS-280 Sp24
// Sydney Nilles
// Assignment 8 - due 03/28/2024

public class Account {
    protected String id;
    protected String name;
    protected int balance;

    // constructor 1, the simple one. Sets balance to 0 for a fresh start.
    public Account (String id, String name){
        this.id = id;
        this.name = name;
        balance = 0;
    }

    // constructor 2, the version where balance is a given variable
    public Account (String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // all the getters all nicely grouped together
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getbalance(){
        return balance;
    }

    // adds to balance
    public int credit(int amount){
        balance += amount;
        return balance;
    }

    //removes from balance if the amount doesn't make it negative
    public int debit(int amount){
        if (amount <= balance){
            balance -= amount;
        } else {
            System.out.println("Amount exceeds the available balance.");
        }
        return balance;
    }

    // Checks that amount is within balance, then removes from this accounts balance. Adds it to anotherAccount
    public int transferTo(Account anotherAccount, int amount){
        if (amount <= balance){
            balance -= amount;
            anotherAccount.credit(amount);
        } else {
            System.out.println("Amount exceeds balance.");
        }
        return balance;
    }
}

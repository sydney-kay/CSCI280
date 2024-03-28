// CS-280 Sp24
// Sydney Nilles
// Assignment 8 - due 03/28/2024

/* <- Annoyance prevention
public class Main {
    public static void main(String[]args){
        Account savings = new Account("67890","Savings", 200);
        Account checking = new Account("12345","Checking");

        // adding money to checking
        checking.credit(200);
        // checking balances
        System.out.println(checking.getName() + ": $" + checking.getbalance());
        System.out.println(savings.getName() + ": $" + savings.getbalance());

        // paying for a really expensive icecream
        checking.debit(18);
        // checking checking's balance again
        System.out.println(checking.getName() + ": $" + checking.getbalance());
        // message sent before it's actually transferred in order to get the correct amount
        System.out.println("Transferring $" +  checking.getbalance());
        checking.transferTo(savings, checking.getbalance());
        // making sure it transferred correctly + printing the final amounts just to see them.
        System.out.println(checking.getName() + ": $" + checking.getbalance());
        System.out.println(savings.getName() + ": $" + savings.getbalance());
    }
}
*/
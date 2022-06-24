/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    private int balance;
    private int leftover;
//     private Account parent;
    private Account parentAccount;

    /** Initialize an account with the given balance. */
    public Account(int balance) {
        this.balance = balance;
        this.parentAccount = null;
    }

//    public Account(int balance, Account parent) {
//        this.balance = balance;
//        this.parent = parent;
//    }

    public Account(int balance, Account parentAccount) {
        this.balance = balance;
        this.parentAccount = parentAccount;
    }
    /** Returns the balance for the current account. */
    public int getBalance() {
        return balance;
    }

    /** Deposits amount into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     *
     * @return
     */
    public boolean withdraw(int amount) {
        if (parentAccount == null) {
            if (amount < 0) {
                System.out.println("Cannot withdraw negative amount.");
                return false;
            } else if (balance < amount) {
                System.out.println("Insufficient funds");
                return false;
            } else {
                balance -= amount;
                return true;
            }
        } else {
            if (amount <= balance ) {
                balance -= amount;
                return true;
            } else if (amount > (balance + parentAccount.balance)) {
                return false;
            } else {
                leftover = amount - balance;
                withdraw(leftover);
                balance = 0;
                parentAccount.balance = parentAccount.balance - leftover;
                return true;

            }

        }
    }


    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO
        this.balance += other.balance;
        other.balance = 0;

    }


}
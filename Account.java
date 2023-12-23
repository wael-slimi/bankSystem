import java.util.List;
import java.util.Scanner;

import javax.swing.text.BadLocationException;

public class Account {
    private int customer_id;
    private String name;
    private String account_number;
    private String accountType;
    private float balance = 0.0f;

    public Account(int customer_id, String name, String address, String contact_number, String account_number, String accountType, float balance) {
        this.customer_id = customer_id;
        this.account_number = account_number;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return account_number;
    }

    public String getAccountType() {
        return accountType;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String toString() {
        return super.toString() + " - Account Number: " + account_number + ", Account Type: " + accountType + ", Balance: " + balance;
    }

    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
}
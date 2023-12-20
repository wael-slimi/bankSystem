import java.util.List;
import java.util.Scanner;

import javax.swing.text.BadLocationException;

public class Account extends Customers {

    private static int lastCustomerId = 0;
    private int customer_id;
    private String account_number;
    private String accountType;
    private float balance = 0.0f;

    public Account(int customer_id, String name, String address, String contact_number, String account_number, String accountType, float balance) {
        super(customer_id, name, address, contact_number);
        this.customer_id = customer_id;
        this.account_number = account_number;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return account_number;
    }

    public String getAccountType(){
        return accountType;
    }
    public float getBalance(){
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
    

    public static Account createAccount() {
        Scanner scanner = new Scanner(System.in);

        // Increment customer_id for the new account
        lastCustomerId++;

        System.out.println("Creating a new account with customer ID: " + lastCustomerId);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        System.out.print("Enter customer contact number: ");
        String contact_number = scanner.nextLine();

        System.out.print("Enter account number: ");
        String account_number = scanner.nextLine();

        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        float balance = scanner.nextFloat();

        // Close the scanner to avoid resource leaks
        scanner.close();

        return new Account(lastCustomerId, name, address, contact_number, account_number, accountType, balance);
    }

    
}

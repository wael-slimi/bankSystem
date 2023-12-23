import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    ArrayList<Account> dataBase = new ArrayList<>();
    private static int lastCustomerId = 0;

    private static String generateAccountNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timestamp = dateFormat.format(new Date());
        return "AC" + timestamp + lastCustomerId;
    }

    public Account createAccount() {
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
    
        // Automatically generate account number based on timestamp and customer ID
        String account_number = generateAccountNumber();
    
        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();
    
        float balance = 0.0f;
    
        // Input validation and exception handling for balance
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter initial balance: ");
                balance = scanner.nextFloat();
    
                if (balance < 0) {
                    throw new IllegalArgumentException("Balance must be non-negative.");
                }
    
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input for balance. Please enter a valid non-negative numeric value.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    
        // Do not close the scanner here
    
        return new Account(lastCustomerId, name, address, contact_number, account_number, accountType, balance);
    }
    

    public static void main(String[] args) {
        int option;
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1) Create an account");
            System.out.println("2) Load accounts");
            System.out.println("3) Retrieve");
            System.out.println("4) Transfer");
            System.out.println("0) Exit");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (option) {
                case 1:
                    Account account = main.createAccount();
                    System.out.println(account.toString());
                    main.dataBase.add(account);
                    break;
                case 2:
                    System.out.println("Option 2");
                    break;
                case 3:
                    System.out.println("Option 3");
                    break;
                case 4:
                    System.out.println("Option 4");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (option != 0);

        // Close the Scanner when you are done with input
        scanner.close();
    }
}
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

    public static String AccountType() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Shouse account type: ");
        System.out.println("1) Courant");
        System.out.println("2) Epargue");

        int option = scanner.nextInt();
        scanner.nextLine(); 

        String type = ""; 

        switch (option) {
            case 1:
                type = "courant";
                break;
            case 2:
                type = "epargue";
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        
        scanner.close(); 
        return type;
    }

    public Account createAccount() {
        Scanner scanner = new Scanner(System.in);
    

        lastCustomerId++;
    
        System.out.println("Creating a new account with customer ID: " + lastCustomerId);
    
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();
    
        System.out.print("Enter customer contact number: ");
        String contact_number = scanner.nextLine();
    
        
        String account_number = generateAccountNumber();
        String accountType;
        /*do{
            System.out.print("account type:(courant/epargue)");
            accountType = scanner.nextLine();
        }while(!accountType.equals("courant") && !accountType.equals("epargue"));
        */
        accountType=Main.AccountType();
    
        float balance = 0.0f;
    
        
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
                scanner.nextLine(); 
            }
        }
    

    
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
            scanner.nextLine(); 
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

       
        scanner.close();
    }
}
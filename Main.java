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

    public void withdraw(float amount, Account account) {
        if ("courant".equals(account.getAccountType())) {
            
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Withdrawal of " + amount + " successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds for withdrawal.");
                System.out.println("To take a loan, please visit the bank.");
            }
        } else if ("epargue".equals(account.getAccountType())) {
            if(amount<=(account.getBalance()/2)){
                float fee = amount*0.05f;
                account.setBalance(account.getBalance() - amount);
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Withdrawal of " + (amount - fee ) + " successful withe fee= "+ fee +". New balance: " + account.getBalance());
                System.out.println("-----------------------------------------------------------------------------------------");
            }else{
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("you are not allaw to withdraw this "+amount+" .You can withdraw only "+account.getBalance()/2);
                System.out.println("-----------------------------------------------------------------------------------------");
            }
            
        } else {
            System.out.println("Invalid account type.");
        }
    }

    public void deposit(float amount, Account account){
        if ("courant".equals(account.getAccountType())) {
            float fee = amount *0.1f;            
            account.setBalance(account.getBalance() + (amount - fee ));
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Deposit of " + (amount - fee) + " successful with %10 "+ fee +". New balance: " + account.getBalance());
            System.out.println("-----------------------------------------------------------------------------------------");
        } else if ("epargue".equals(account.getAccountType())) {
            float fee = amount*0.05f;
            account.setBalance(account.getBalance() + (amount-fee));
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("deposit of " + (amount - fee ) + " successful withe %5 fee= "+ fee +". New balance: " + account.getBalance());
            System.out.println("-----------------------------------------------------------------------------------------");

            
        } else {
            System.out.println("Invalid account type.");
        }
    }


    public void transfer(float amount, Account sourceAccount, Account targetAccount) {
        if ("courant".equals(sourceAccount.getAccountType())) {
            if (sourceAccount.getBalance() >= amount) {
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                targetAccount.setBalance(targetAccount.getBalance() + amount);
                System.out.println("Transfer of " + amount + " from " + sourceAccount.getName() +
                        " to " + targetAccount.getName() + " successful.");
                System.out.println("New balance of " + sourceAccount.getName() + ": " + sourceAccount.getBalance());
                System.out.println("New balance of " + targetAccount.getName() + ": " + targetAccount.getBalance());
            } else {
                System.out.println("Insufficient funds for the transfer from " + sourceAccount.getName());
            }
        } else {
            System.out.println("Transfer can only be initiated from a 'courant' account.");
        }
    }
    


    public Account createAccount() {
        Scanner scanner = new Scanner(System.in);
    

        lastCustomerId++;
    
        System.out.println("Creating a new account with customer ID: " + lastCustomerId);
    
        System.out.print("Enter customer full name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();
    
        System.out.print("Enter customer contact number: ");
        String contact_number = scanner.nextLine();
    
        
        String account_number = generateAccountNumber();
        String accountType;
        do{
            System.out.print("account type:(courant/epargue)");
            accountType = scanner.nextLine();
        }while(!accountType.equals("courant") && !accountType.equals("epargue"));
        
    
        float balance = 0.0f;
    
        
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter initial balance: ");
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
            System.out.println("\n***************************************************************************");
            System.out.println("Choose an option:");
            System.out.println("1) Create account");
            System.out.println("2) deposit");
            System.out.println("3) withdrow");
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

                    boolean isValidIdForDeposit = false;
                    int depositId = -1;
                
                    while (!isValidIdForDeposit) {
                        System.out.println("Enter the account ID for deposit: ");
                        depositId = scanner.nextInt();
                        scanner.nextLine();
                
                        for (Account a : main.dataBase) {
                            if (a.getCustomer() == depositId) {
                                isValidIdForDeposit = true;
                                break;
                            }
                        }
                
                        if (!isValidIdForDeposit) {
                            System.out.println("Invalid account ID. Please enter a valid ID.");
                        }
                    }
                
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Valid account ID entered for deposit: " + depositId);
                    System.out.println("-----------------------------------------------------------------------------------------");
                
                    Account depositAccount = main.dataBase.get(depositId - 1);
                
                    System.out.print("Enter the deposit amount for " + depositAccount.getName() + " (current balance: " + depositAccount.getBalance() + "): ");
                    float depositAmount = scanner.nextFloat();
                    main.deposit(depositAmount, depositAccount);
                    break;
                
                case 3:
                    boolean isValidId = false;
                    int id = -1;
                    while (!isValidId) {
                        System.out.println("Enter the account ID: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); 
                    
                        for (Account a : main.dataBase) {
                            if (a.getCustomer() == id) {
                                isValidId = true;
                                break;  
                            }
                        }
                    
                        if (!isValidId) {
                            System.out.println("Invalid account ID. Please enter a valid ID.");
                        }
                    }
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Valid account ID entered: " + id);
                    System.out.println("-----------------------------------------------------------------------------------------");
                    
                    Account withdrawAccount = main.dataBase.get(id-1);
                    if("courant".equals(withdrawAccount.getAccountType())){
                        System.out.print(" enter the withdrawal amount for " + withdrawAccount.getName() + "with id= "+withdrawAccount.getCustomer()+" (your current amount="+withdrawAccount.getBalance()+") : ");
                    }else{
                        System.out.print(" enter the withdrawal amount for " + withdrawAccount.getName() + "with id= "+withdrawAccount.getCustomer()+" (your current amount="+withdrawAccount.getBalance()+")your not allowed to withdraw only the half of the amount : ");
                    }
                        
                    float withdrawalAmount = scanner.nextFloat();
                    main.withdraw(withdrawalAmount, withdrawAccount);                    
                    break;
                
                case 4:
                    boolean isValidSourceId = false;
                    int sourceId = -1;
                    while (!isValidSourceId) {
                        System.out.println("Enter the source account ID for transfer: ");
                        sourceId = scanner.nextInt();
                        scanner.nextLine();
                
                        for (Account a : main.dataBase) {
                            if (a.getCustomer() == sourceId) {
                                isValidSourceId = true;
                                break;
                            }
                        }
                
                        if (!isValidSourceId) {
                            System.out.println("Invalid source account ID. Please enter a valid ID.");
                        }
                    }
                
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Valid source account ID entered for transfer: " + sourceId);
                    System.out.println("-----------------------------------------------------------------------------------------");
                
                    Account sourceAccount = main.dataBase.get(sourceId - 1);
                
                    System.out.println("Enter the target account ID for transfer: ");
                    int targetId = scanner.nextInt();
                    scanner.nextLine();
                
                    Account targetAccount = main.dataBase.get(targetId - 1);
                
                    System.out.print("Enter the transfer amount from " + sourceAccount.getName() +" to " + targetAccount.getName() + " (current balance: " + sourceAccount.getBalance() + "): ");
                    float transferAmount = scanner.nextFloat();
                    main.transfer(transferAmount, sourceAccount, targetAccount);
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
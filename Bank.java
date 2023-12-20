import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Account> listAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.run();
    }

    public void run() {
        int option = -1;

        do {
            displayMenu();

            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        createAccount();
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

            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid option.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }

        } while (option != 0);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1) Create an account");
        System.out.println("2) Load accounts");
        System.out.println("3) Retrieve");
        System.out.println("4) Transfer");
        System.out.println("0) Exit");
    }

    private void createAccount() {
        Account account = Account.createAccount();
        listAccounts.add(account);
        System.out.println("Account created successfully. Details:");
        System.out.println(account);

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}

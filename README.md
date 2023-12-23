# Banking System

This is a simple banking system implemented in Java. The system allows users to create accounts, deposit funds, withdraw funds, and perform transfers between accounts. Each account has a unique account number, and customers can have either a "courant" or "epargue" account type.

## Features

- **Create Account**: Users can create a new account by providing their full name, address, contact number, and initial balance. The system generates a unique account number for each new account.

- **Deposit Funds**: Account holders can deposit funds into their accounts. The deposit process varies based on the account type, with different fee structures for "courant" and "epargue" accounts.

- **Withdraw Funds**: Account holders can withdraw funds from their accounts. The withdrawal process is also account-type-dependent, with specific rules for "courant" and "epargue" accounts.

- **Transfer Funds**: The system supports fund transfers between accounts. However, the transfer functionality is not yet implemented and is marked as a future enhancement.

- **Exit**: Users can choose to exit the system at any time.

## How to Use

1. Run the program.
2. Choose an option from the menu:
    - **1)** Create an account
    - **2)** Deposit funds
    - **3)** Withdraw funds
    - **4)** Transfer funds (currently not implemented)
    - **0)** Exit

3. Follow the prompts to provide necessary information for the selected option.
4. Repeat steps 2-3 until you choose to exit.

## Account Types

- **Courant Account**: This account type allows users to withdraw funds if the balance is sufficient. A 10% fee is applied during deposits.

- **Epargue Account**: For this account type, users can withdraw up to half of the account balance. A 5% fee is applied during deposits.

## Notes

- The withdrawal process includes specific messages for different scenarios, such as insufficient funds or restrictions on withdrawal amount for "epargue" accounts.
- The deposit process includes fee deductions based on the account type.

## Future Enhancements

- Implement the transfer funds functionality.
- Add more error handling and validation for user inputs.
- Enhance the user interface for a more user-friendly experience.

Feel free to contribute to this project and add more features!
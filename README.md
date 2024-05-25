# Online Banking System using Java

This project is a simple Online Banking System implemented in Java. It provides basic functionalities like user account creation and authentication, account balance inquiry, fund transfers between accounts, and transaction history.

## Features

- User account creation and authentication
- Account balance inquiry
- Fund transfers between accounts
- Transaction history

## Installation

1. **Clone the repository**

   ```sh
   git clone https://github.com/An1rud/Online-banking-system-using-Java.git
   cd Online-banking-system-using-Java
   ```

2. **Compile the Java files**

   Ensure you have the Java Development Kit (JDK) installed. You can check this by running `java -version` and `javac -version` in your terminal or command prompt.

   ```sh
   javac User.java Bank.java OnlineBankingSystem.java
   ```

3. **Run the main class**

   ```sh
   java OnlineBankingSystem
   ```

## Usage

After running the `OnlineBankingSystem` class, you will be presented with a menu:

```
Welcome to the Online Banking System
1. Create an account
2. Log in
3. Exit
Choose an option:
```

### Creating an Account

1. Choose the option `1. Create an account`.
2. Enter a username and password when prompted.

### Logging In

1. Choose the option `2. Log in`.
2. Enter your username and password when prompted.

### User Menu

Once logged in, you will have the following options:

1. **Check balance**: View your current account balance.
2. **Deposit funds**: Deposit a specified amount into your account.
3. **Withdraw funds**: Withdraw a specified amount from your account (if funds are sufficient).
4. **Transfer funds**: Transfer a specified amount to another user's account.
5. **View transaction history**: View a list of all transactions made on your account.
6. **Log out**: Log out of the system.

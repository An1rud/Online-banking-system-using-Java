import java.util.Scanner;

public class OnlineBankingSystem {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Online Banking System");
            System.out.println("1. Create an account");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank you for using the Online Banking System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (bank.createUser(username, password)) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = bank.authenticateUser(username, password);
        if (user != null) {
            System.out.println("Login successful.");
            userMenu(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void userMenu(User user) {
        while (true) {
            System.out.println("1. Check balance");
            System.out.println("2. Deposit funds");
            System.out.println("3. Withdraw funds");
            System.out.println("4. Transfer funds");
            System.out.println("5. View transaction history");
            System.out.println("6. Log out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    user.deposit(depositAmount);
                    System.out.println("Deposited $" + depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Withdrew $" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    System.out.print("Enter username to transfer to: ");
                    String toUsername = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    if (bank.transferFunds(user.getUsername(), toUsername, transferAmount)) {
                        System.out.println("Transferred $" + transferAmount + " to " + toUsername);
                    } else {
                        System.out.println("Transfer failed.");
                    }
                    break;
                case 5:
                    System.out.println("Transaction history:");
                    for (String transaction : user.getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

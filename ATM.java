import java.util.Scanner;

public class ATM {
    private static final String PIN = "1234"; // Example PIN
    private static double balance = 1000; // Example balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while (true) {
            System.out.println("Welcome to the ATM Interface");
            System.out.println("Enter PIN:");
            String enteredPin = scanner.nextLine();

            if (enteredPin.equals(PIN)) {
                loggedIn = true;
                break;
            } else {
                System.out.println("Invalid PIN. Try again.");
            }
        }

        while (loggedIn) {
            System.out.println("\nATM Interface Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void transfer(Scanner scanner) {
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}

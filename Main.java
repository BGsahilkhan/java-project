import java.util.Scanner;

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Transaction successful");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private static final int PIN = 1234;

    public boolean authenticate(Scanner sc) {
        System.out.print("Enter PIN: ");
        int input = sc.nextInt();
        return input == PIN;
    }

    public void showMenu(Account acc, Scanner sc) {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        acc.withdraw(amount);
                        break;
                    case 2:
                        System.out.println("Balance: " + acc.getBalance());
                        break;
                    case 3:
                        System.out.println("Thank you for using ATM");
                        break;
                    default:
                        System.out.println("Invalid choice, try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account(2000);
        ATM atm = new ATM();

        if (atm.authenticate(sc)) {
            atm.showMenu(acc, sc);
        } else {
            System.out.println("Access Denied");
        }

        sc.close();
    }
}
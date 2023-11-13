import java.util.Scanner;

import models.Account;
import services.Authentication;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Authentication class
        Authentication authentication = new Authentication();
        Scanner scanner = new Scanner(System.in);

        // Create dummy accounts and add them to the authentication system
        Account account1 = new Account("Rana", "rana@gmail.com", "01146993561", "1234", 1000.0);
        authentication.addAccount(account1);

        Account account2 = new Account("Nour", "nour@gmail.com", "01126134834", "5678", 500.0);
        authentication.addAccount(account2);

        // Prompt the user to choose between login and logout
        System.out.println("Choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Logout");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Login case
                System.out.println("Enter login credentials:");
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();

                Account loginAttempt = authentication.login(username, password);
                if (loginAttempt != null) {
                    System.out.println("Login successful. Welcome, " + loginAttempt.getName() + "!");
                } else {
                    System.out.println("Incorrect login attempt. No account found with the given credentials.");
                }
                break;

            case 2:
                // Logout case
                if (authentication.isLoggedIn()) {
                    authentication.logout();
                    System.out.println("Logout successful.");
                } else {
                    System.out.println("No one is currently logged in. Cannot logout.");
                }
                break;

            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
        }
        // Check if someone is logged in after login/logout
        if (authentication.isLoggedIn()) {
            System.out.println("Someone is currently logged in.");
            System.out.println("Logged-in account: " + authentication.getLoggedInAccount().getName());
        } else {
            System.out.println("No one is currently logged in.");
        }
        // Close the scanner
        scanner.close();
    }
}

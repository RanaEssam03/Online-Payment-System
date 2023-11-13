import java.util.Scanner;

import models.Account;
import services.Authentication;

public class Main {
    private static Account currentUser;

    public static void main(String[] args) {
        // Create an instance of the Authentication class
        Authentication authentication = new Authentication();
        Scanner scanner = new Scanner(System.in);

        // Create dummy accounts and add them to the authentication system
        Account account1 = new Account("Rana", "rana@gmail.com", "01146993561", "1234", 1000.0);
        authentication.addAccount(account1);

        Account account2 = new Account("Nour", "nour@gmail.com", "01126134834", "5678", 500.0);
        authentication.addAccount(account2);
        while (true) {
            // Prompt the user to choose between login, logout, or exit
            System.out.println("Choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Exit");

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
                        currentUser = loginAttempt;
                        System.out.println("Login successful. Welcome, " + currentUser.getName() + "!");
                    } else {
                        System.out.println("Incorrect login attempt. No account found with the given credentials.");
                    }
                    break;

                case 2:
                    // Logout case
                    if (currentUser != null) {
                        authentication.logout();
                        System.out.println("Logout successful for " + currentUser.getName() + ".");
                        currentUser = null;
                    } else {
                        System.out.println("No one is currently logged in. Cannot logout.");
                    }
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        }
    }
}

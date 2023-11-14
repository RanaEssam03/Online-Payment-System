package services;

import models.Account.Account;

import java.util.Random;

import static Database.Data.*;

public class Authentication {
    public void setLoggedInAccount(Account loggedInAccount) {
        this.loggedInAccount = loggedInAccount;
    }

    private Account loggedInAccount;

    // Method to add an account to the authentication system

    public Account login(String name, String password) {
        for (Account account : accounts) {
            if (account.getUserName().equals(name) && account.getPassword().equals(password)) {
                return account; // Login successful, return the account
            }
        }
        return null; // No account found with the given credentials
    }

    public void logout() {
        loggedInAccount = null; // Reset the logged-in account
    }

    // Method to check if someone is logged in
    public boolean isLoggedIn() {
        return loggedInAccount != null;
    }

    // Get the currently logged-in account
    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public void sendOtp(String userEmail) {
        String generatedOtp = generateRandomOtp();
        System.out.println("OTP sent to " + userEmail + ": " + generatedOtp);
    }

    public String generateRandomOtp() {
        // Generate a random OTP of the specified length
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10)); // Appending a random digit (0-9)
        }

        return otp.toString();
    }

    public boolean verifyOtp(String code) {
        String generatedOtp = generateRandomOtp();
        return generatedOtp.equals(code);
    }
}


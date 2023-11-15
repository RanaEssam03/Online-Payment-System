package services;

import models.Account.Account;

import java.util.Random;

import static Database.Data.*;

/**
 * The Authentication class handles user authentication and provides methods for login, logout,
 * checking login status, and OTP (One-Time Password) functionality.
 */
public class Authentication {
    /**
     * Sets the currently logged-in account.
     *
     * @param loggedInAccount The account to set as the logged-in account.
     */
    public void setLoggedInAccount(Account loggedInAccount) {
        this.loggedInAccount = loggedInAccount;
    }

    private Account loggedInAccount;

    /**
     * Attempts to log in with the provided username and password.
     *
     * @param name     The username to log in with.
     * @param password The password to log in with.
     * @return The logged-in account if successful, or null if login fails.
     */

    public Account login(String name, String password) {
        for (Account account : accounts) {
            if (account.getUserName().equals(name) && account.getPassword().equals(password)) {
                return account; // Login successful, return the account
            }
        }
        return null; // No account found with the given credentials
    }

    /**
     * Logs out the currently logged-in account.
     */
    public void logout() {
        loggedInAccount = null; // Reset the logged-in account
    }

    /**
     * Checks if a user is currently logged in.
     *
     * @return true if a user is logged in, false otherwise.
     */
    public boolean isLoggedIn() {
        return loggedInAccount != null;
    }

    /**
     * Gets the currently logged-in account.
     *
     * @return The currently logged-in account, or null if no user is logged in.
     */
    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    /**
     * Sends an OTP (One-Time Password) to the specified user email.
     *
     * @param userEmail The email address to which the OTP will be sent.
     */
    public void sendOtp(String userEmail) {
        String generatedOtp = generateRandomOtp();
        System.out.println("OTP sent to " + userEmail + ": " + generatedOtp);
    }

    /**
     * Generates a random OTP (One-Time Password) of length 6.
     *
     * @return The generated OTP.
     */
    public String generateRandomOtp() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10)); // Appending a random digit (0-9)
        }

        return otp.toString();
    }

    /**
     * Verifies if the provided OTP code matches the generated OTP.
     *
     * @param code The OTP code to verify.
     * @return true if the OTP code is valid, false otherwise.
     */
    public boolean verifyOtp(String code) {
        String generatedOtp = generateRandomOtp();
        return generatedOtp.equals(code);
    }
}


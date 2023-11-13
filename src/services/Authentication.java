package services;

import models.Account;

import java.util.List;
import java.util.ArrayList;

public class Authentication {
    private List<Account> accounts;
    private Account loggedInAccount;

    public Authentication() {
        this.accounts = new ArrayList<>();
        this.loggedInAccount = null;  // No one is logged in initially
    }

    // Method to add an account to the authentication system
    public void addAccount(Account account) {
        accounts.add(account);
    }

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
//    public boolean verifyOtp(String code ){
//
//    }
}


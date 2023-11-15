package services;

import models.Account.Account;

import static Database.Data.*;

public class Authentication {
    public void setLoggedInAccount(Account loggedInAccount) {
        this.loggedInAccount = loggedInAccount;
    }

    private Account loggedInAccount;

//    public Authentication() {
//        this.accounts = new ArrayList<>();
//        this.loggedInAccount = null;  // No one is logged in initially
//    }

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
//    public boolean verifyOtp(String code ){
//
//    }
}


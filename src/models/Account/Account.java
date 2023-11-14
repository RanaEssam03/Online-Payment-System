/**
 * The {@code Account} class represents a user account with basic information such as
 * username, mobile number, email, password, balance, and transaction history.
 **/
package models.Account;

import java.util.List;

public class Account {

    /**
     * Parameterized constructor for the {@code Account} class.
     *
     * @param userName the username of the account
     * @param mobile the mobile number associated with the account
     * @param password the password for the account
     * @param balance the initial balance of the account
     * @param email the email associated with the account
     */
    private String mobile;
    String email;
    private String userName;
    private String password;
    private double balance;
    private List<String> history;

    /**
     * Default constructor for the {@code Account} class.
     */
    public Account() {

    }

    // Constructor
    public Account(String userName, String mobile, String password, double balance, String email) {
        this.userName = userName;
        this.mobile = mobile;
        this.password = password;
        this.balance = balance;
        this.email = email;
    }

    /**
     * Getter for the mobile number.
     *
     * @return the mobile number associated with the account
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Setter for the mobile number.
     *
     * @param mobile the new mobile number to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Getter for the email address.
     *
     * @return the email address associated with the account
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email address.
     *
     * @param email the new email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Getter for the account password.
     *
     * @return the password associated with the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the account password.
     *
     * @param password the new password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the account balance.
     *
     * @return the current balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter for the account balance.
     *
     * @param balance the new balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Getter for the username.
     *
     * @return the username associated with the account
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for the username.
     *
     * @param userName the new username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}

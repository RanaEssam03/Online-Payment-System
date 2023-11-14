package models.Account;

import java.util.List;

public class Account {
    public Account() {

    }
    private String mobile;
    String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    private String password;
    private double balance;
    private List<String> history;


    // Constructor
    public Account(String userName, String mobile, String password, double balance, String email) {
        this.userName = userName;
        this.mobile = mobile;
        this.password = password;
        this.balance = balance;
        this.email = email;
    }



    // Getter for mobile
    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Setter for mobile
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

}

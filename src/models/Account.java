package models;

import java.util.List;

public class Account {
    private String name;
    private String mobile;
    String email;
    private String password;
    private double balance;
    private List<String> history;


    // Constructor
    public Account(String name, String mobile,String email, String password, double balance) {
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.balance = balance;
        this.email=email;
    }

    public Account() {

    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for mobile
    public String getMobile() {
        return mobile;
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

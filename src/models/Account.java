package models;

import java.util.List;

public abstract class  Account {
    private String name;
    private String mobile;
    private String password;
    private double balance;
    private List<Integer> history;

    // Constructor
    public Account(String name, String mobile, String password, double balance, List<Integer> history) {
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.balance = balance;
        this.history = history;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
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

    // Getter for history
    public List<Integer> getHistory() {
        return history;
    }

    // Setter for history
    public void setHistory(List<Integer> history) {
        this.history = history;
    }
}

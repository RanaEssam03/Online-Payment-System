package models;

import java.util.List;

public class Account {
    private String name;
    private String mobile;
    String email;
    private String password;
    private double balance;
    private List<String> history;

    public String getName() {
        return name;
    }
    public String getMobile() {
        return mobile;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

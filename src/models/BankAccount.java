package models;

import java.util.List;

public class BankAccount extends Account {
    int AccountNumber;
    String bankName;

    public BankAccount(String name, String mobile, String email, String password, double balance) {
        super(name, mobile, email, password, balance);
    }
}

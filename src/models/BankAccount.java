package models;

import java.util.List;

public class BankAccount extends Account {
    int AccountNumber;
    String bankName;

    public BankAccount(String name, String mobile, String password, double balance) {
        super(name, mobile, password, balance);
    }
}

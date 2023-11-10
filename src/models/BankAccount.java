package models;

import java.util.List;

public class BankAccount extends Account {
    private int AccountNumber;

    public BankAccount(String name, String mobile, String password, double balance, List<Integer> history) {
        super(name, mobile, password, balance, history);
    }
}

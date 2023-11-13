package models;

import java.util.List;


public class BankAccount extends Account {

    int AccountNumber;
    String bankName;
    BankType bankType;

    enum BankType {
        Saving,
        Checking,
    }

    public BankType getBankType() {
        return bankType;
    }
    public void setBankType(BankType bankType) {
        this.bankType =bankType;
    }

    public BankAccount(String name, String mobile, BankType bankType, String password, double balance) {
        super(name, mobile, password, balance);
        this.bankType = bankType;
    }


}
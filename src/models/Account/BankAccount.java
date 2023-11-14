package models.Account;

import models.Account.Account;
import models.Account.BankAccountType;

public class BankAccount extends Account {
    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    String AccountNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    String bankName;

    public BankAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    BankAccountType accountType;
    public BankAccount(){
        super();
    }

    public BankAccount(String userName, String mobile, String password, double balance, String email) {
        super(userName, mobile, password, balance, email);
    }

    public BankAccountType getBankType() {
        return accountType;
    }

    public void setBankType(BankAccountType bankType) {
        this.accountType = bankType;
    }

    public BankAccount(String name, String mobile, BankAccountType bankType, String password, double balance, String email) {
        super(name, mobile, password, balance, email);
        this.accountType = bankType;
    }


}

package models;

public class BankAccount extends Account {

    int AccountNumber;
    String bankName;

    BankAccountType bankType;

    public BankAccount() {
        super();
    }

    public BankAccount(String name, String mobile, String password, double balance) {
        super(name, mobile, password, balance);


    }

    public BankAccountType getBankType() {
        return bankType;
    }

    public void setBankType(BankAccountType bankType) {
        this.bankType = bankType;
    }

    public BankAccount(String name, String mobile, BankAccountType bankType, String password, double balance) {
        super(name, mobile, password, balance);
        this.bankType = bankType;
    }


}

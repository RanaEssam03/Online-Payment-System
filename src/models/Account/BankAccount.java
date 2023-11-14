package models.Account;

import models.Account.Account;
import models.Account.BankAccountType;
/**
 * The {@code BankAccount} class represents a user's bank account with additional
 * information such as account number, bank name, and account type.
 **/
 public class BankAccount extends Account {
    /**
     * Getter for the account number.
     *
     * @return the account number associated with the bank account
     */
    public String getAccountNumber() {
        return AccountNumber;
    }

    /**
     * Setter for the account number.
     *
     * @param accountNumber the new account number to set
     */
    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    /**
     * The account number associated with the bank account.
     */
    String AccountNumber;
    /**
     * Getter for the bank name.
     *
     * @return the name of the bank associated with the account
     */
    public String getBankName() {
        return bankName;
    }
    /**
     * Setter for the bank name.
     *
     * @param bankName the new bank name to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * The name of the bank where the account is held.
     */
    String bankName;

    public BankAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(BankAccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * The type of the bank account (e.g., savings or checking).
     */
    BankAccountType accountType;

    /**
     * Default constructor for the {@code BankAccount} class.
     */
    public BankAccount() {
        super();
    }

    public BankAccount(String userName, String mobile, String password, double balance, String email) {
        super(userName, mobile, password, balance, email);
    }
    /**
     * Getter for the bank account type.
     *
     * @return the type of the bank account (e.g., savings or checking)
     */
    public BankAccountType getBankType() {
        return accountType;
    }
    /**
     * Setter for the bank type.
     *
     * @param bankType the new account type to set
     */
    public void setBankType(BankAccountType bankType) {
        this.accountType = bankType;
    }

    /**
     * Parameterized constructor for the {@code BankAccount} class.
     *
     * @param name     the username of the account
     * @param mobile   the mobile number associated with the account
     * @param bankType the type of the bank account (e.g., savings or checking)
     * @param password the password for the account
     * @param balance  the initial balance of the account
     * @param email    the email associated with the account
     */
    public BankAccount(String name, String mobile, BankAccountType bankType, String password, double balance, String email) {
        super(name, mobile, password, balance, email);
        this.accountType = bankType;
    }


}

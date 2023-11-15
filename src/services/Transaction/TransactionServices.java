package services.Transaction;

import models.Account.Account;
import providers.Account.AccountProvider;
import services.UserServices;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code TransactionServices} class is an abstract class representing transaction-related services.
 * It includes methods for transferring funds, inquiring about account balance, and transferring to Instapay accounts.
 */

abstract public class TransactionServices {
    protected AccountProvider transactionProvider;
    protected UserServices userServices = new UserServices();
    Account account;

    /**
     * Constructs a new {@code TransactionServices} instance with the specified transaction provider and account.
     *
     * @param transactionProvider the provider for account transactions
     * @param account             the account associated with the transaction services
     */
    public TransactionServices(AccountProvider transactionProvider, Account account) {
        this.transactionProvider = transactionProvider;
        this.account = account;
    }

    /**
     * Abstract method to transfer funds to another account.
     *
     * @param amount       the amount to transfer
     * @param mobileNumber the mobile number associated with the recipient account
     * @return {@code true} if the transfer is successful, {@code false} otherwise
     * @throws IOException if an I/O error occurs during the transfer
     */
    abstract public boolean transfer(double amount, String mobileNumber) throws IOException;

    /**
     * Abstract method to inquire about the account balance.
     *
     * @return the account balance
     * @throws IOException if an I/O error occurs during the inquiry
     */
    abstract public double inquire() throws IOException;

    /**
     * Abstract method to transfer funds to an Instapay account.
     *
     * @param amount         the amount to transfer
     * @param username       the username associated with the Instapay account
     * @param currentAccount the current account from which the transfer is initiated
     * @return a list of booleans indicating the success of each transfer
     * @throws IOException if an I/O error occurs during the transfer
     */
    abstract public ArrayList<Boolean> transferToInstapayAccount(double amount, String username, Account currentAccount) throws IOException;

}

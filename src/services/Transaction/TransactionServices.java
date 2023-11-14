package services.Transaction;

import models.Account.Account;
import providers.Account.AccountProvider;

import java.io.IOException;



abstract public class TransactionServices {
    protected AccountProvider transactionProvider;
    Account account;

    public TransactionServices(AccountProvider transactionProvider, Account account) {
        this.transactionProvider = transactionProvider;
        this.account = account;
    }

    abstract public boolean transfer(double amount, String mobileNumber) throws IOException;

   abstract public double inquire() throws IOException;

}

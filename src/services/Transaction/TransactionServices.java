package services.Transaction;

import models.Account.Account;
import providers.Transaction.TransactionProvider;

import java.io.IOException;



abstract public class TransactionServices {
    protected TransactionProvider transactionProvider;
    Account account;

    public TransactionServices(TransactionProvider transactionProvider, Account account) {
        this.transactionProvider = transactionProvider;
        this.account = account;
    }

    abstract public boolean transfer(double amount, String mobileNumber) throws IOException;

   abstract public double inquire() throws IOException;

}

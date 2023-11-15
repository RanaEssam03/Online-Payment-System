package services.Transaction;

import models.Account.Account;
import providers.Account.AccountProvider;
import services.UserServices;

import java.io.IOException;
import java.util.ArrayList;


abstract public class TransactionServices {
    protected AccountProvider transactionProvider;
    protected UserServices userServices = new UserServices();
    Account account;

    public TransactionServices(AccountProvider transactionProvider, Account account) {
        this.transactionProvider = transactionProvider;
        this.account = account;
    }

    abstract public boolean transfer(double amount, String mobileNumber) throws IOException;

   abstract public double inquire() throws IOException;


   abstract public ArrayList<Boolean> transferToInstapayAccount(double amount, String username, Account currentAccount) throws IOException;

}

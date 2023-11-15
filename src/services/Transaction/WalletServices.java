package services.Transaction;

import models.Account.Account;
import providers.Account.WalletProvider;

import java.io.IOException;
import java.util.ArrayList;


public class WalletServices extends TransactionServices {

    public WalletServices(String walletName, Account account) {
        super(new WalletProvider(walletName), account);

    }


    @Override
    public boolean transfer(double amount, String mobileNumber) throws IOException {
        if (transactionProvider.transferToWallet(amount, mobileNumber, account)) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;

    }

    @Override
    public double inquire() throws IOException {
        return transactionProvider.getBalance(account);
    }

    @Override
    public ArrayList<Boolean> transferToInstapayAccount(double amount, String username, Boolean notFound, Account currentAccount) throws IOException {
        ArrayList<Boolean> ret = new ArrayList<>();
        if (!userServices.verifyAccount(username)) {
            ret.add(false);
            ret.add(false);
            return ret;
        }

        ret.add(true);

        if (transactionProvider.withdraw(amount, currentAccount)) {
            account.setBalance(account.getBalance() - amount);
            ret.add(true);
        }
        ret.add(false);
        return ret;
    }

}




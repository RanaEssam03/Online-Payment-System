package services.Transaction;
import models.Account.Account;
import providers.Account.WalletProvider;

import java.io.IOException;


public class WalletServices extends TransactionServices {

        public WalletServices(String walletName, Account account){
            super(new WalletProvider(walletName), account );

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
        return transactionProvider.getBalance(account.getMobile(), account);
    }
}

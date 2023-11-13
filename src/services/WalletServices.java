package services;
import providers.WalletProvider;

import java.io.IOException;


public class WalletServices extends TransactionServices {

        public WalletServices(String name){
            WalletProvider walletProvider = new WalletProvider(name);
            super.transactionProvider = walletProvider;
        }

        public void transferToWalletAccount(int amount, String walletNumber) throws IOException {
            if (transactionProvider.transferToWallet(amount, walletNumber)){
                account.setBalance(account.getBalance() - amount);
            }
        }
}

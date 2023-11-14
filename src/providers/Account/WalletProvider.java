package providers.Account;//package providers;


import models.Account.Account;

import java.io.IOException;

public class WalletProvider extends AccountProvider {

    public WalletProvider(String name) {
        super(name);
    }

    @Override
    public double getBalance(String mobileNumber, Account currentAccount) throws IOException {
        System.out.println("Get balance from wallet using " + connection.getApiURL());
        System.out.println();

        return 1000;
    }

    @Override
    public boolean withdraw(double amount, Account currentAccount) {
        System.out.println("Withdraw from wallet using " + connection.getApiURL());
        System.out.println();
        return true;
    }

    @Override
    public boolean transferToWallet(double amount, String mobileNumber, Account currentAccount) throws IOException {
        System.out.println("Transfer to wallet using " + connection.getApiURL());
        System.out.println();
        return true;
    }
}
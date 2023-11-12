package models;

import java.util.List;

public class WalletAccount extends Account {
    String walletName;

    public WalletAccount(String name, String mobile, String password, double balance) {
        super(name, mobile, password, balance);
    }
}

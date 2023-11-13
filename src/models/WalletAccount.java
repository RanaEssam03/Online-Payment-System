package models;

public class WalletAccount extends Account{
    String walletNumber; //needed to make transactions with the wallet number

    String walletName;
    public WalletAccount(){
        super();
    }

    public WalletAccount(String name, String mobile, String password, double balance) {
        super(name, mobile, password, balance);
    }
}

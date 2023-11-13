package models;

public class WalletAccount extends Account {
    String walletName;

    public WalletAccountType getWalletAccountType() {
        return walletAccountType;
    }

    public void setWalletAccountType(WalletAccountType walletAccountType) {
        this.walletAccountType = walletAccountType;
    }

    WalletAccountType walletAccountType;
    public WalletAccount(){
        super();
    }

    public WalletAccount(String userName, String mobile, String password, double balance, String email) {
        super(userName, mobile, password, balance, email);
    }
    public WalletAccount(String name, String mobile, WalletAccountType walletType, String password, double balance, String email) {
        super(name, mobile, password, balance, email);
        this.walletAccountType = walletType;
    }


}

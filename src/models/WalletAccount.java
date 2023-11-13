package models;

public class WalletAccount extends Account {
    String walletName;
    WalletType walletType; // Use the enum

    public enum WalletType {
        EtisaleteCash,
        VodafoneCash,
        CIB,
    }
    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }
    public WalletAccount(String name, String mobile, WalletType walletType, String password, double balance) {
        super(name, mobile, password, balance);
        this.walletType = walletType;
    }


}

package models.Account;

/**
 * The {@code WalletAccount} class represents a user's wallet account with additional
 * information such as wallet name and wallet account type.
 **/
public class WalletAccount extends Account {
    /**
     * The name of the wallet associated with the account.
     */
    String walletName;

    /**
     * Getter for the wallet account type.
     *
     * @return the type of the wallet account (e.g., prepaid or digital)
     */
    public WalletAccountType getWalletAccountType() {
        return walletAccountType;
    }

    /**
     * Setter for the wallet account type.
     *
     * @param walletAccountType the new wallet account type to set
     */
    public void setWalletAccountType(WalletAccountType walletAccountType) {
        this.walletAccountType = walletAccountType;
    }

    /**
     * The type of the wallet account (e.g., prepaid or digital).
     */
    WalletAccountType walletAccountType;

    /**
     * Default constructor for the {@code WalletAccount} class.
     */
    public WalletAccount() {
        super();
    }

    public WalletAccount(String userName, String mobile, String password, double balance, String email) {
        super(userName, mobile, password, balance, email);
    }

    /**
     * Parameterized constructor for the {@code WalletAccount} class.
     *
     * @param name       the username of the account
     * @param mobile     the mobile number associated with the account
     * @param walletType the type of the wallet account (e.g., prepaid or digital)
     * @param password   the password for the account
     * @param balance    the initial balance of the account
     * @param email      the email associated with the account
     */
    public WalletAccount(String name, String mobile, WalletAccountType walletType, String password, double balance, String email) {
        super(name, mobile, password, balance, email);
        this.walletAccountType = walletType;
    }


}

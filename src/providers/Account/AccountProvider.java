package providers.Account;

import models.Account.Account;
import models.ConnectionAPI;

import java.io.IOException;

abstract public class AccountProvider {
    ConnectionAPI connection;

    public AccountProvider(String name) {
        this.connection = new ConnectionAPI(name);
    }

    /**
     * this method is used to get the balance of the user from the remote server
     *
     * @param mobileNumber the mobile number of the user
     * @return
     * @throws IOException
     */
    public abstract double getBalance(String mobileNumber, Account currentAccount) throws IOException;

    /**
     * this method is used to withdraw money from the user account from the remote server
     *
     * @param amount
     * @return
     */
    public abstract boolean withdraw(double amount, Account currentAccount);

    /**
     * this method is used to transfer money to another user account from the remote server
     *
     * @param amount
     * @param mobileNumber
     * @return
     * @throws IOException
     */
    public abstract boolean transferToWallet(double amount, String mobileNumber, Account currentAccount) throws IOException;
    

}

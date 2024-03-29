/// @Author Rana Essam
// Last Modified By: Rana Essam
// last modified: 14-11-2023
/***
 * Description: This class contains the basic http requests methods that any account could use in different services
 * it contains the following methods:
 * 1- transferToWallet: this method is used to transfer money to another user wallet from the remote server
 * 2- inquire: this method is used to inquire the balance of the user from the remote server
 * 3- payBills: this method is used to pay bills from the remote server
 * 4- withdraw: this method is used to withdraw money from the user account from the remote server
 */
package providers.Account;

import models.Account.Account;
import models.ConnectionAPI;

import java.io.IOException;

abstract public class AccountProvider {
    ConnectionAPI connection;

    /**
     * this method is used to verify the presence of this bank account using the mobile number from the remote server
     *
     * @param mobileNumber the mobile number of the user
     * @param provider     the provider's name
     */
    abstract public boolean verifyAccount(String mobileNumber, String provider);

    /**
     * this constructor is used to initialize the connection with the remote server
     *
     * @param name the name of the remote server
     */
    public AccountProvider(String name) {
        this.connection = new ConnectionAPI(name);
    }

    /**
     * this method is used to get the balance of the user from the remote server
     *
     * @return
     * @throws IOException
     */
    public abstract double getBalance(Account currentAccount) throws IOException;

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

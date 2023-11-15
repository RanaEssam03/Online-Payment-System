/// @Author Rana Essam
// Last Modified By: Rana Essam
// last modified: 14-11-2023
/**
 * Description: This class contains the implementation of the basic http requests methods in wallet companies manner (Vodafone Cash, Etisalat Cash)
 * it contains the following methods:
 * 2- inquire: this method is used to inquire the balance of the user from the remote server
 * 3- payBills: this method is used to pay bills from the remote server
 * 4- withdraw: this method is used to withdraw money from the user account from the remote server
 * 5- transferToWallet: this method is used to transfer money to another user wallet from the remote server
 */
package providers.Account;
import Database.Data;
import models.Account.Account;
import java.io.IOException;

public class WalletProvider extends AccountProvider {

    /**
     * this constructor is used to initialize the connection with the remote server
     * @param name the name of the remote server
     */
    public WalletProvider(String name) {
        super(name);
    }

    /**
     *
     * @param currentAccount the current account that will inquire the balance
     * @return the balance of the user from the remote server (bank)
     * @throws IOException if the connection is not established
     */
    @Override
    public double getBalance( Account currentAccount) throws IOException {
        System.out.println("Get balance from wallet using " + connection.getApiURL());
     return Data.walletsMap.get(connection.getName()).get(currentAccount.getMobile());



    }

    /**
     * this method is used to withdraw money from the user account from the remote server
     * @param amount the amount of money that will be withdrawn
     * @param currentAccount the current account that will withdraw the money
     * @return true if the withdraw is done successfully, false otherwise
     */
    @Override
    public boolean withdraw(double amount, Account currentAccount) {
        double currentBalance = Data.walletsMap.get(connection.getName()).get(currentAccount.getMobile());
        if (currentBalance < amount) {
            return false;
        }
        Data.walletsMap.get(connection.getName()).put(currentAccount.getMobile(), currentBalance - amount);

        System.out.println("Withdraw from wallet using " + connection.getApiURL());
        System.out.println();
        return true;
    }

    /**
     * this method is used to transfer money to another user account from the remote server
     * @param amount the amount of money that will be transferred
     * @param mobileNumber the mobile number of the user that will receive the money
     * @param currentAccount the current account that will transfer the money
     * @return true if the transfer is done successfully, false otherwise
     * @throws IOException if the connection is not established
     */
    @Override
    public boolean transferToWallet(double amount, String mobileNumber, Account currentAccount) throws IOException {
        double currentBalance = Data.walletsMap.get(connection.getName()).get(currentAccount.getMobile());
        if (currentBalance < amount) {
            return false;
        }
        Data.walletsMap.get(connection.getName()).put(currentAccount.getMobile(), currentBalance - amount);
        System.out.println("Transfer to wallet using " + connection.getApiURL());
        System.out.println();
        return true;
    }
}
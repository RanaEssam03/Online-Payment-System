/// @Author Rana Essam
// Last Modified By: Rana Essam
// last modified: 14-11-2023
/**
 * Description: This class contains the implementation of the basic http requests methods in bank manner (CIB, NBE)
 * and also contains the implementation of the transfer to bank account method
 * it contains the following methods:
 * 2- inquire: this method is used to inquire the balance of the user from the remote server
 * 3- payBills: this method is used to pay bills from the remote server
 * 4- withdraw: this method is used to withdraw money from the user account from the remote server
 * 5- transferToWallet: this method is used to transfer money to another user wallet from the remote server
 * 6- transferToBank: this method is used to transfer money to another user bank account from the remote server
 */
package providers.Account;

import java.io.IOException;
import Database.Data;
import models.Account.Account;
import models.Account.BankAccount;

import static Database.Data.banksMap;

public class BankProvider extends AccountProvider {

    @Override
    public boolean verifyAccount(String mobileNumber, String provider) {
        return banksMap.get(provider).containsKey(mobileNumber);
    }

    /**
     * this method is used to get the account number of this bank account using the mobile number from the remote server
     *
     * @param mobileNumber the mobile number of the user
     * @param provider the provider's name
     */
    public String getAccountNumber(String mobileNumber, String provider) {
        return banksMap.get(provider).get(mobileNumber)[0];
    }

    /**
     * this constructor is used to initialize the connection with the remote server
     * @param name the name of the remote server
     */
    public BankProvider(String name) {
        super(name);
    }

    @Override
    public double getBalance(String mobileNumber, Account currentAccount) throws IOException {
        System.out.println("Get balance from wallet using " + connection.getApiURL());
        System.out.println();
        String currentBank = connection.getName();
        return Double.parseDouble( Data.banksMap.get(currentBank).get(currentAccount.getMobile())[1]); // here we get the balance of my demo database which represents the bank server in the real world
    }

    @Override
    public boolean withdraw(double amount, Account currentAccount) {
        System.out.println("Transfer to wallet using " + connection.getApiURL());

        // TODO : verify that the wallet is exists
        String currentBank = connection.getName();
        Double currentAccountsBalance = Double.parseDouble( Data.banksMap.get(currentBank).get(currentAccount.getMobile())[0]); // here we get the balance of my demo database which represents the bank server in the real world
        if( currentAccountsBalance < amount){

            return false;
        }
        Data.banksMap.get(currentBank).get(currentAccount.getMobile())[0] = String.valueOf(currentAccountsBalance - amount);
        return true;
    }

    /**
     * this method is used to transfer money to another user wallet from the remote server (bank)
     * it will check if the account  exists or not and if the balance is enough or not and then it will transfer the money
     * @param amount the amount of money that will be transferred
     * @param mobileNumber the mobile number of the user that will receive the money
     * @return true if the transfer is done successfully and false if not
     * @throws IOException if the connection is not established
     */
    @Override
    public boolean transferToWallet(double amount, String mobileNumber, Account currentAccount) throws IOException {
        System.out.println("Transfer to wallet using " + connection.getApiURL());

        // TODO : verify that the wallet is exists
        String currentBank = connection.getName();
       Double currentAccountsBalance = Double.parseDouble( Data.banksMap.get(currentBank).get(currentAccount.getMobile())[0]); // here we get the balance of my demo database which represents the bank server in the real world
        if( currentAccountsBalance < amount){
            return false;
        }
        Data.banksMap.get(currentBank).get(currentAccount.getMobile())[0] = String.valueOf(currentAccountsBalance - amount);

        return true;
    }

    /**
     * this method is used to transfer money to another user wallet from the remote server (bank) using the account number
     * it will check if the account  exists or not and if the balance is enough or not and then it will transfer the money to the account
     * @param amount the amount of money that will be transferred
     * @param accountNumber the account number of the user that will receive the money
     * @return true if the transfer is done successfully and false if not
     * @throws IOException if the connection is not established
     */
    public boolean transferToBank(double amount, String accountNumber, Account currentAccount) throws IOException {
        System.out.println("Transfer to Bank Account using " + connection.getApiURL());

        // TODO : verify that the bank is exists
        String currentBank = connection.getName();
        Double currentAccountsBalance = Double.parseDouble( Data.banksMap.get(currentBank).get(currentAccount.getMobile())[0]);
        if( currentAccountsBalance < amount){
            return false;
        }
        Data.banksMap.get(currentBank).get(currentAccount.getMobile())[0] = String.valueOf(currentAccountsBalance - amount);

        return true;
    }
}

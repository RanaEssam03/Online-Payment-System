/// @Author Rana Essam
// Last Modified By: Rana Essam
// last modified: 14-11-2023
/***
 * Description: This class contains all the services that the user could do with the bank account
 * it contains the following methods:
 * 1- transferToBankAccount: this method is used to transfer money to another user bank account from the remote server (bank)
 * 2- transfer: this method is used to transfer money to another user wallet from the remote server (bank)
 * 3- inquire: this method is used to inquire the balance of the user from the remote server (bank)
 * 4- payBills: this method is used to pay bills from the remote server (bank)
 */

package services.Transaction;

import models.Account.Account;
import providers.Account.BankProvider;

import java.io.IOException;
import java.util.ArrayList;

public class BankServices extends TransactionServices  {
    public BankServices(String bankName, Account account) {
        super(new BankProvider(bankName), account);
    }



    public boolean transferToBankAccount(double amount, String accountNumber) throws IOException {

      BankProvider transactionProvider = (BankProvider) super.transactionProvider;
       if(transactionProvider.transferToBank(amount, accountNumber, account)){
           account.setBalance(account.getBalance() - amount);
           return true;
       }
       // here should return false as the balance is not enough
       return false;
    }

    /**
     * this method is used to transfer money to another user wallet from the remote server (bank)
     * @param amount the amount of money that will be transferred
     * @param mobileNumber the mobile number of the user that will receive the money
     * @return true if the transfer is done successfully and false if not
     * @throws IOException if the connection is not established
     */
    @Override
    public boolean transfer(double amount, String mobileNumber) throws IOException {
    
        if (transactionProvider.transferToWallet(amount, mobileNumber, account)) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }

        return false;
    }

    /**
     * this method is used to inquire the balance of the user from the remote server (bank)
     * @return the balance of the user from the remote server (bank)
     * @throws IOException if the connection is not established
     */
    @Override
    public double inquire() throws IOException {

        return transactionProvider.getBalance( account);
    }

    /**
     * this method is transfer money to another instapay account
     * @param amount to be transferred
     * @param username to be transferred to
     * @param currentAccount the current account that will withdraw the money
     * @return  array list of booleans to indicate if the transaction is done successfully or not -> index 1and if the user exists or not -> index0
     *
     * @throws IOException if the connection is not established
     */
    @Override
    public ArrayList<Boolean> transferToInstapayAccount(double amount, String username, Account currentAccount) throws IOException {
        ArrayList<Boolean> ret  = new ArrayList<>();
        if (!userServices.verifyAccount(username)){
            ret.add(false);
            ret.add(false);
            return ret;
        }

        ret.add(true);

        if (transactionProvider.withdraw(amount,  currentAccount)){
            account.setBalance(account.getBalance() - amount);
            ret.add(true);
        }
        ret.add(false);
        return ret;
    }
}
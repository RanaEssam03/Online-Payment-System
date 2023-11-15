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

    @Override
    public ArrayList<Boolean> transferToInstapayAccount(double amount, String username, Boolean notFound, Account currentAccount) throws IOException {
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
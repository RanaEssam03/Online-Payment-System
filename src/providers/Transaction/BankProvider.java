package providers.Transaction;//package providers;

import java.io.IOException;
import Database.Data;
import models.Account;
import models.BankAccount;

public class BankProvider extends TransactionProvider {


    public BankProvider(String name) {
        super(name);
    }

    @Override
    public double getBalance(String mobileNumber, Account currentAccount) throws IOException {
        System.out.println("Get balance from wallet using " + connection.getApiURL());
        System.out.println();
        String currentBank = connection.getName();
        return Double.parseDouble( Data.banksMap.get(currentBank).get(currentAccount.getMobile())[0]); // here we get the balance of my demo database which represents the bank server in the real world
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

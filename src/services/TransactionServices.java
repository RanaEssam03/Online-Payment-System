package services;

import models.Account;
import providers.ConnectionAPI;

public abstract class TransactionServices {
    Account account;

    ConnectionAPI connectionAPI; // This the api provider that will be used for the transaction services

     void transferToWallet(int amount, String mobileNumber){
        System.out.println("Transfer using transaction services using " + connectionAPI.getName());
     }
     double inquire(){

        System.out.println("Inquire using transaction services using " + connectionAPI.getName());
        return account.getBalance();
    }
    public void payBills(){
         // TODO implement  bills
        System.out.println("Pay bills using transaction services using " + connectionAPI.getName());
    }
}

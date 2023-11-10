package services;

import models.Account;
import providers.APIProvider;

public abstract class TransactionServices {
    Account account;

    APIProvider apiProvider; // This the api provider that will be used for the transaction services

     void transferToWallet(int amount, String mobileNumber){
        System.out.println("Transfer using transaction services using " + apiProvider.getName());
     }
     double inquire(){

        System.out.println("Inquire using transaction services using " + apiProvider.getName());
        return account.getBalance();
    }
    public void payBills(){
         // TODO implement  bills
        System.out.println("Pay bills using transaction services using " + apiProvider.getName());
    }
}

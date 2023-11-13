package services;

import models.Account;
import providers.TransactionProvider;

import java.io.IOException;


//public abstract class TransactionServices {
//    Account account;
//
//  // This the api provider that will be used for the transaction services
//
//     void transferToWallet(int amount, String mobileNumber){
//        System.out.println("Transfer using transaction services using " + apiProvider.getName());
//     }
//     double inquire(){
//
//        System.out.println("Inquire using transaction services using " + apiProvider.getName());
//        return account.getBalance();
//    }
//    public void payBills(){
//         // TODO implement  bills
//        System.out.println("Pay bills using transaction services using " + apiProvider.getName());
//    }
//}


abstract public class TransactionServices {
    protected TransactionProvider transactionProvider;
    Account account;


    boolean transfer(double amount, String mobileNumber) throws IOException {
        if (transactionProvider.transferToWallet(amount, mobileNumber)) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;

    }

    public double inquire() throws IOException {
        return transactionProvider.getBalance(account.getMobile());
    }

}

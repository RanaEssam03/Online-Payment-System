package services.Transaction;//package services;

import models.Account.Account;
import providers.Account.BankProvider;

import java.io.IOException;

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

    @Override
    public boolean transfer(double amount, String mobileNumber) throws IOException {
        if(amount > 1000000){
            System.out.println("You can't transfer more than 1000000");
            return false;
        }
        if (transactionProvider.transferToWallet(amount, mobileNumber, account)) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        else {
            System.out.println("You Don't have enough money");

        }
        return false;
    }

    @Override
    public double inquire() throws IOException {
        return transactionProvider.getBalance(account.getMobile(), account);
    }
}
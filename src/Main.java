
import models.Account;

import models.BankAccount;
import models.WalletAccount;
import services.GUIManager;


import java.io.IOException;

import static Database.Data.accounts;
import static Database.Data.setCurrentAccounts;


public class Main {
    public static void main(String[] args) throws IOException {
        setCurrentAccounts();
        System.out.println("Welcome to our online payment system");
        GUIManager GUI = new GUIManager();
        Account loggedInAccount;
        loggedInAccount = GUI.authenticate();
        if(loggedInAccount == null){
            return;
        }
        if(loggedInAccount instanceof BankAccount){
            GUI.bankAccountTransaction((BankAccount) loggedInAccount);
        }
        else if(loggedInAccount instanceof WalletAccount){
            GUI.walletTransaction((WalletAccount) loggedInAccount);
        }


//        for(Account account : accounts){
//            System.out.println(account.getUserName() + " " + account.getPassword() + " " + account.getMobile() + " " + account.getBalance());
//        }
        //menu using all the app's features
    }
}

import Database.Data;
import models.Account;
import models.BankAccount;
import models.WalletAccount;
import providers.BankProvider;
import providers.WalletProvider;
import services.GUIManager;
import services.UserServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        for(Account account : accounts){
            System.out.println(account.getUserName());
        }
        //menu using all the app's features
    }
}

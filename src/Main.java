import models.Account;
import models.BankAccount;
import models.WalletAccount;
import providers.APIProvider;
import providers.BankProvider;
import providers.WalletProvider;
import services.GUIManager;
import services.UserServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our online payment system");
        GUIManager guiManager = new GUIManager();
        guiManager.authenticate();
        //menu for logging in and using all the app's features
    }
}

package services;

import models.Account;
import models.Authentication;
import models.BankAccount;
import models.WalletAccount;
import providers.APIProvider;
import providers.BankProvider;
import providers.WalletProvider;

import java.util.Scanner;

import static Database.Data.bankAccounts;
import static Database.Data.walletAccounts;

public class GUIManager {
    private UserServices userServices = new UserServices();
    public void authenticate(){
        System.out.println("Please choose one of these options:-");
        System.out.println("1. Register using bank account.");
        System.out.println("2. Register using E-Wallet.");
        System.out.println("3. Login");
        System.out.print("Choice: ");
        Scanner in = new Scanner(System.in);
        int choice;
        choice = in.nextInt();
        if (choice == 4) {
            return;
        }
        switch (choice) {
            case 1:
                Scanner input = new Scanner(System.in);
                String [] banks = {"CIB", "HSBC", "National Bank of Egypt"};
                System.out.println("Please choose one of these banks:-");
                System.out.println("1. " + banks[0]);
                System.out.println("2. " + banks[1]);
                System.out.println("3. " + banks[2]);
                System.out.print("Choice: ");
                int c;
                c = in.nextInt();
                if(c - 1 >= banks.length){
                    System.out.println("Invalid bank choice, please re-enter your choice: ");
                    c = in.nextInt();
                }
                BankAccount bankAccount= new BankAccount();
                System.out.print("Please enter the attached mobile number to your bank account: ");
                String mobileNumber;
                mobileNumber = input.nextLine();
                while(!userServices.register()){
                    System.out.println("There is no bank account with this mobile number, please re-enter a valid mobile number");
                    mobileNumber = input.nextLine();
                }
                bankAccounts.add(bankAccount);
                String userName = bankAccount.getUserName();
                String password = bankAccount.getPassword();
                //call login function and pass username and password
                break;
            case 2:
                Scanner input2 = new Scanner(System.in);
                String [] wallets = {"Vodafone Cash", "Etisalat Cash"};
                System.out.println("Please choose one of these wallets:-");
                System.out.println("1. " + wallets[0]);
                System.out.println("2. " + wallets[1]);
                System.out.print("Choice: ");
                int b;
                b = in.nextInt();
                if(b - 1 >= wallets.length){
                    System.out.println("Invalid wallet choice, please re-enter your choice: ");
                    b = in.nextInt();
                }
                WalletAccount walletAccount= new WalletAccount();
                APIProvider walletProvider = new WalletProvider(wallets[b - 1]);
                String mobile_number;
                mobile_number = input2.nextLine();
                while(!userServices.register(){
                    System.out.print("This mobile number has no wallet, please re-enter your mobile number: ");
                    mobile_number = input2.nextLine();
                }
                walletAccounts.add(walletAccount);
                break;
            case 3:
                //login
                break;
        }
    }
}


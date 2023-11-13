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
    static ArrayList<Account> accounts = new ArrayList<>();
    public static void mainMenu() throws IOException {
        System.out.println("Please choose one of these options:-");
        System.out.println("1. Register using bank account.");
        System.out.println("2. Register using E-Wallet.");
        System.out.println("3. Login");
        System.out.println("3. Exit");
        Scanner in = new Scanner(System.in);
        int choice;
        choice = in.nextInt();
        if (choice == 4) {
            return;
        }
        UserServices userServices = new UserServices(); //function's place is here if we put login, logout along with user services
        switch (choice) {
            case 1:
                Scanner input = new Scanner(System.in);
                String [] banks = {"CIB", "HSBC", "National Bank of Egypt"};
                System.out.println("Please choose one of these banks:-");
                System.out.println("1. " + banks[0]);
                System.out.println("2. " + banks[1]);
                System.out.println("3. " + banks[2]);
                int c;
                c = in.nextInt();
                if(c - 1 >= banks.length){
                    System.out.println("Invalid bank choice, please re-enter your choice: ");
                    c = in.nextInt();
                }
                Account bankAccount= new BankAccount();
                APIProvider bankProvider = new BankProvider("CIB");
                System.out.print("Please enter the attached mobile number to your bank account: ");
                String mobileNumber;
                mobileNumber = input.nextLine();
                System.out.println(mobileNumber);
                while(!userServices.register(bankAccount, mobileNumber, bankProvider)){
                    System.out.println("There is no bank account with this mobile number.");
                    //mobileNumber = input.nextLine();
                    mainMenu();
                }
                accounts.add(bankAccount);
                String userName = bankAccount.getUserName();
                String password = bankAccount.getPassword();
                //call login function and pass username and password
                break;
            case 2:
                Scanner input2 = new Scanner(System.in);
                String [] wallets = {"Vodafone Cash", "Fawry"};
                System.out.println("Please choose one of these banks:-");
                System.out.println("1. " + wallets[0]);
                System.out.println("2. " + wallets[1]);
                int b;
                b = in.nextInt();
                if(b - 1 >= wallets.length){
                    System.out.println("Invalid wallet choice, please re-enter your choice: ");
                    b = in.nextInt();
                }
                Account walletAccount = new WalletAccount();
                APIProvider walletProvider = new WalletProvider(wallets[b - 1]);
                String mobile_number;
                mobile_number = input2.nextLine();
                while(!userServices.register(walletAccount, mobile_number, walletProvider)){
                    System.out.print("This mobile number has no wallet, please re-enter your mobile number: ");
                    mobile_number = input2.nextLine();
                }
                break;
            case 3:
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to our online payment system");
        GUIManager manager = new GUIManager();
        manager.authenticate();

    }
}
package views;
import models.*;
import models.Account.*;
import services.Authentication;
import java.io.IOException;
import providers.verification.BankVerification;
import providers.verification.WalletVerification;
import services.UserServices;
import java.util.Scanner;
import static Database.Data.*;

public class InstaPay {
    private AccountType currentAccountType;
    public Authentication authentication = new Authentication();
    private UserServices userServices = new UserServices();

    public AccountType getCurrentAccountType() {
        return currentAccountType;
    }
    public void setCurrentAccountType(AccountType currentAccountType) {
        this.currentAccountType = currentAccountType;
    }
     Account authenticate(){
        Account loggedInAccount;
        System.out.println("Please choose one of these options:-");
        System.out.println("1. Register using bank account.");
        System.out.println("2. Register using E-Wallet.");
        System.out.println("3. Login");
        System.out.println("4. Exit");
        System.out.print("Choice: ");
        int choice;
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        if (choice == 4) {
            return null;
        }
        switch (choice) {
            case 1: {
                Scanner in1 = new Scanner(System.in);
                Scanner input = new Scanner(System.in);
                String[] banks = {"CIB", "HSBC", "National Bank of Egypt"};
                System.out.println("Please choose one of these banks:-");
                System.out.println("1. " + banks[0]);
                System.out.println("2. " + banks[1]);
                System.out.println("3. " + banks[2]);
                System.out.print("Choice: ");
                int c;
                c = in1.nextInt();
                if (c - 1 >= banks.length) {
                    System.out.print("Invalid bank choice, please re-enter your choice: ");
                    c = in.nextInt();
                }
                BankAccount bankAccount = new BankAccount();
                ConnectionAPI connectionBankAPI = new ConnectionAPI(banks[c - 1]);
                BankVerification bankVerification = new BankVerification();
                bankVerification.setConnection(connectionBankAPI);
                System.out.print("Please enter the attached mobile number to your bank account: ");
                String mobileNumber;
                mobileNumber = input.nextLine();
                while (!userServices.register(bankAccount, mobileNumber, bankVerification, banks[c - 1])) {
                    System.out.print("There mobile number has no bank account, please re-enter a valid mobile number: ");
                    mobileNumber = input.nextLine();
                }
                bankAccount.setBankName(banks[c - 1]);
                bankAccount.setBalance(bankVerification.getBalance(mobileNumber, banks[c - 1]));
                bankAccount.setAccountNumber(bankVerification.getAccountNumber(mobileNumber, banks[c - 1]));
                accounts.add(bankAccount);
                bankAccounts.add(bankAccount);
                currentAccountType = AccountType.BankAccount;
                return bankAccount;
            }
            case 2:
            {
                Scanner in2 = new Scanner(System.in);
                Scanner input2 = new Scanner(System.in);
                String[] wallets = {"Vodafone Cash", "Etisalat Cash"};
                System.out.println("Please choose one of these wallets:-");
                System.out.println("1. " + wallets[0]);
                System.out.println("2. " + wallets[1]);
                System.out.print("Choice: ");
                int b;
                b = in2.nextInt();
                if(b - 1 >= wallets.length){
                    System.out.println("Invalid wallet choice, please re-enter your choice: ");
                    b = in.nextInt();
                }
                WalletAccount walletAccount= new WalletAccount();
                ConnectionAPI connectionWalletAPI = new ConnectionAPI(wallets[b - 1]);
                WalletVerification walletVerification = new WalletVerification();
                walletVerification.setConnection(connectionWalletAPI);
                if(b == 1) {
                    walletAccount.setWalletAccountType(WalletAccountType.VodafoneCash);
                }
                else{
                    walletAccount.setWalletAccountType(WalletAccountType.EtisalatCash);
                }
                System.out.print("Please enter the attached mobile number to your wallet account: ");
                String mobile_number;
                mobile_number = input2.nextLine();
                while(!userServices.register(walletAccount, mobile_number, walletVerification, wallets[b - 1])){
                    System.out.print("This mobile number has no wallet, please re-enter your mobile number: ");
                    mobile_number = input2.nextLine();
                }
                accounts.add(walletAccount);
                walletAccounts.add(walletAccount);
                currentAccountType = AccountType.WalletAccount;
                return walletAccount;
            }
            case 3: {
                //login
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter login credentials:");
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String passwordLogin = scanner.next();
                while ((loggedInAccount = authentication.login(username, passwordLogin)) == null) {
                    System.out.println("Please enter valid credentials");
                    System.out.print("Username: ");
                    username = scanner.next();
                    System.out.print("Password: ");
                    passwordLogin = scanner.next();
                }
                System.out.println("Logged in to your account successfully");
                return loggedInAccount;
            }
        }
        return null;
    }

    public void run () throws IOException {
        setCurrentAccounts();
        System.out.println("Welcome to our online payment system");
        Account loggedInAccount;
        loggedInAccount = authenticate();
        if(loggedInAccount == null){
            return;
        }
        if(loggedInAccount instanceof BankAccount){
            BankAccountView bankView = new BankAccountView((BankAccount) loggedInAccount);
            bankView.run();
        }
        else if(loggedInAccount instanceof WalletAccount){
            WalletAccountView walletView = new WalletAccountView((WalletAccount) loggedInAccount);
            walletView.run();
        }
    }

}


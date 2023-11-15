/// @Author Rana Essam
// Last Modified By: Rana Essam
// last modified: 14-11-2023
/**
 * Description: This class contains the main entry point of the program
 * it contains the following methods:
 * 1- run: this method is used to run the program
 * 2- authenticate: this method is used to authenticate the user and register him
 */
package views;
import models.*;
import models.Account.*;
import providers.Account.AccountProvider;
import providers.Account.BankProvider;
import providers.Account.WalletProvider;
import services.Authentication;
import java.io.IOException;
import services.UserServices;
import java.util.Scanner;
import static Database.Data.*;
import static java.lang.System.exit;

public class InstaPay {
    private AccountType currentAccountType;
    public Authentication authentication = new Authentication();
    private UserServices userServices = new UserServices();

    /**
     * this method is used to authenticate the user and register him  it will return the account that the user logged in with
     * @return the account that the user logged in with
     */
     Account authenticate() throws IOException {
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
            exit(0);
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
                BankProvider bankAccountProvider = new BankProvider(banks[c - 1]);
                System.out.print("Please enter the attached mobile number to your bank account: ");
                String mobileNumber;
                mobileNumber = input.nextLine();
                while (!userServices.register(bankAccount, mobileNumber, bankAccountProvider, banks[c - 1])) {
                    System.out.print("There mobile number has no bank account, please re-enter a valid mobile number: ");
                    mobileNumber = input.nextLine();
                }
                bankAccount.setBankName(banks[c - 1]);
                bankAccount.setBalance(bankAccountProvider.getBalance( bankAccount));
                bankAccount.setAccountNumber(bankAccountProvider.getAccountNumber(mobileNumber, banks[c - 1]));
                accounts.add(bankAccount);
                bankAccounts.add(bankAccount);
                currentAccountType = AccountType.BankAccount;
                System.out.print("\n");
                System.out.println(bankAccount.getUserName() + "                 " + bankAccount.getBalance() + "                 " + bankAccount.getBankName());
                System.out.print("\n");
                loggedInAccount = bankAccount;
                return loggedInAccount;
            }
            case 2:
            {
                Scanner in2 = new Scanner(System.in);
                Scanner input2 = new Scanner(System.in);
                String[] wallets = {"VodafoneCash", "EtisalatCash"};
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
                WalletProvider walletProvider = new WalletProvider(wallets[b - 1]);
                if(b == 1) {
                    walletAccount.setWalletAccountType(WalletAccountType.VodafoneCash);
                }
                else{
                    walletAccount.setWalletAccountType(WalletAccountType.EtisalatCash);
                }
                System.out.print("Please enter the attached mobile number to your wallet account: ");
                String mobile_number;
                mobile_number = input2.nextLine();
                while(!userServices.register(walletAccount, mobile_number, walletProvider, wallets[b - 1])){
                    System.out.print("This mobile number has no wallet, please re-enter your mobile number: ");
                    mobile_number = input2.nextLine();
                }
                walletAccount.setBalance(walletProvider.getBalance(walletAccount));
                accounts.add(walletAccount);
                walletAccounts.add(walletAccount);
                currentAccountType = AccountType.WalletAccount;
                System.out.print("\n");
                System.out.println(walletAccount.getUserName() + "                 " + walletAccount.getBalance() +  "                 " +  walletAccount.getWalletAccountType().toString());
                System.out.print("\n");
                loggedInAccount = walletAccount;
                return loggedInAccount;
            }
            case 3: {
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
                System.out.print("\n");
                System.out.println(username + "                 " + loggedInAccount.getBalance() + "                 ");
                System.out.print("\n");
                return loggedInAccount;
            }
        }
        return null;
    }

    /**
     * this method is used to run the program
     * @throws IOException if the connection is not established
     */
    public void run () throws IOException {
        setCurrentAccounts();
      while (true){
          System.out.println("\n_______________________________________________________________________");
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

}


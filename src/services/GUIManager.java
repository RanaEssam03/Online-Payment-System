package services;

import models.Account;
import models.BankAccount;
import models.Bills.Bill;
import models.WalletAccount;
import providers.BillPayment.BillCompany;
import providers.BillPayment.ElectricityCompany;
import providers.BillPayment.GasCompany;
import providers.BillPayment.WaterCompany;
import providers.Transaction.BankProvider;
import providers.Transaction.TransactionProvider;
import providers.Transaction.WalletProvider;
import services.Transaction.BankServices;
import services.Transaction.WalletServices;

import java.io.IOException;
import java.util.Scanner;

import static Database.Data.*;

public class GUIManager {
    private UserServices userServices = new UserServices();

    public void authenticate() throws IOException {
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
                String[] banks = {"CIB", "HSBC", "National Bank of Egypt"};
                System.out.println("Please choose one of these banks:-");
                System.out.println("1. " + banks[0]);
                System.out.println("2. " + banks[1]);
                System.out.println("3. " + banks[2]);
                System.out.print("Choice: ");
                int c;
                c = in.nextInt();
                if (c - 1 >= banks.length) {
                    System.out.println("Invalid bank choice, please re-enter your choice: ");
                    c = in.nextInt();
                }
                BankAccount bankAccount = new BankAccount();
                System.out.print("Please enter the attached mobile number to your bank account: ");
                String mobileNumber;
                mobileNumber = input.nextLine();
                while (!userServices.register(new Account(), mobileNumber)) {
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
                String[] wallets = {"Vodafone Cash", "Etisalat Cash"};
                System.out.println("Please choose one of these wallets:-");
                System.out.println("1. " + wallets[0]);
                System.out.println("2. " + wallets[1]);
                System.out.print("Choice: ");
                int b;
                b = in.nextInt();
                if (b - 1 >= wallets.length) {
                    System.out.println("Invalid wallet choice, please re-enter your choice: ");
                    b = in.nextInt();
                }
                WalletAccount walletAccount = new WalletAccount();
//                APIProvider walletProvider = new WalletProvider(wallets[b - 1]);
                String mobile_number;
                mobile_number = input2.nextLine();

                while (!userServices.register(new Account(), mobile_number)) {
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


    static void walletTransaction(WalletAccount currentAccount) throws IOException {
//     BankProvider transactionProvider = (BankProvider) super.transactionProvider;

        WalletServices walletServices = new WalletServices(currentAccount.getWalletAccountType().toString(), currentAccount);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose one of these options:-");
            System.out.println("1. Transfer to another wallet.");
            System.out.println("2. Inquire balance.");
            System.out.println("3. Pay bills.");
            System.out.println("4. Exit.");
            System.out.print("Choice: ");
            int choice;
            choice = in.nextInt();
            if (choice == 4) {
                return;
            }
            if (choice == 1) {
                System.out.println("Please enter the mobile number of the wallet you want to transfer to: ");
                String mobileNumber;
                mobileNumber = in.next();
                System.out.println("Please enter the amount you want to transfer: ");
                double amount;
                amount = in.nextDouble();
                walletServices.transfer(amount, mobileNumber);
            } else if (choice == 2) {
                System.out.println("Your balance is: " + walletServices.inquire());
            } else if (choice == 3) {
                billPayment(currentAccount, new WalletProvider(currentAccount.getWalletAccountType().toString()));

            }

        }
    }

    static void billPayment(Account currentAccount, TransactionProvider transactionProvider) throws IOException {
        System.out.println("Please choose one of these options:-");
        System.out.println("1. Gas.");
        System.out.println("2. Electricity.");
        System.out.println("3. Water.");
        System.out.print("Choice: ");
        BillCompany billCompany = null;
        Scanner in = new Scanner(System.in);
        String billType = in.nextLine();
        switch (billType) {
            case "1":
                billCompany = new GasCompany();
                break;
            case "2":
                billCompany = new ElectricityCompany();
                break;
            case "3":
                billCompany = new WaterCompany();
                break;
            default:
                System.out.println("Invalid choice");
                return;

        }

        BillServices billServices = new BillServices(billCompany, transactionProvider);

        System.out.println("Please choose one of these options:-");
        System.out.println("1. Inquire bill.");
        System.out.println("2. Pay bill.");
        System.out.print("Choice: ");
        int choice;
        choice = in.nextInt();
        if (choice == 1) {
            Bill bill = billServices.inquire();
            System.out.println(bill.toString());
        } else if (choice == 2) {
            if (billServices.pay(billCompany.getBill(), currentAccount)) {
                System.out.println("Bill paid successfully");
            } else {
                System.out.println("Bill payment failed");
            }
        }


        // TODo Create a function to pay bills

    }

    static void bankAccountTransaction(BankAccount currentAccount) throws IOException {

        BankServices bankServices = new BankServices(currentAccount.getBankName(), currentAccount);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose one of these options:-");
            System.out.println("1. Transfer to another bank account.");
            System.out.println("2. Transfer to another wallet.");
            System.out.println("3. Inquire balance.");
            System.out.println("4. Pay bills.");
            System.out.println("5. Exit.");
            System.out.print("Choice: ");
            int choice;
            choice = in.nextInt();
            if (choice == 5) {
                return;
            }
            if (choice == 1) {
                System.out.println("Please enter the account number of the bank account you want to transfer to: ");
                String accountNumber;
                accountNumber = in.next();
                System.out.println("Please enter the amount you want to transfer: ");
                double amount;
                amount = in.nextDouble(); // TODO
                if (!bankServices.transfer(amount, accountNumber)) {
                    System.out.println("You don't have enough balance to transfer this amount.");
                }
            } else if (choice == 2) {
                System.out.println("Please enter the account number of the bank account you want to transfer to: ");
                String accountNumber;
                accountNumber = in.next();
                System.out.println("Please enter the amount you want to transfer: ");
                double amount;
                amount = in.nextDouble(); // TODO
                if (!bankServices.transfer(amount, accountNumber)) {
                    System.out.println("You don't have enough balance to transfer this amount.");
                }
            } else if (choice == 3) {
                System.out.println("Your balance is: " + bankServices.inquire());
            } else if (choice == 4) {
                billPayment(currentAccount, new BankProvider(currentAccount.getBankName()));
            }

        }


    }


    public static void main(String[] args) throws IOException {
        setCurrentAccounts();
//        walletTransaction(walletAccounts.get(0), "Vodafone");
        bankAccountTransaction(bankAccounts.get(0));
    }
}


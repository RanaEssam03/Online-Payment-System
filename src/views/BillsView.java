package views;

import models.Account.Account;
import models.Bills.Bill;
import providers.Account.AccountProvider;
import providers.BillPayment.BillCompany;
import providers.BillPayment.ElectricityCompany;
import providers.BillPayment.GasCompany;
import providers.BillPayment.WaterCompany;
import services.BillServices;
import java.util.Random;
import java.util.Scanner;

public class BillsView {
    Account currentAccount;
    AccountProvider transactionProvider;

    public BillsView(Account currentAccount, AccountProvider transactionProvider) {
        this.currentAccount = currentAccount;
        this.transactionProvider = transactionProvider;
    }


    public void run(){
        System.out.println("Please choose one of these options:-");
        System.out.println("1. Gas.");
        System.out.println("2. Electricity.");
        System.out.println("3. Water.");
        System.out.print("Choice: ");
        BillCompany billCompany;
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
            System.out.println("Please enter your customer ID: ");
            Integer customerID;
            customerID = in.nextInt();
            Bill bill = billServices.inquire();
            bill.printBill();
        } else if (choice == 2) {
            System.out.println("Please enter your customer ID: ");
            Integer customerID;
            customerID = in.nextInt();
            Random random = new Random();
            customerID = random.nextInt(1000);
            if (billServices.pay(billCompany.getBill(customerID), currentAccount)) {
                System.out.println("Bill paid successfully");
            } else {
                System.out.println("Bill payment failed");
            }
        }

    }

}

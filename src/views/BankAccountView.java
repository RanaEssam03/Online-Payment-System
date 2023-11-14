
package views;
import models.Account.BankAccount;
import providers.Account.BankProvider;
import services.Transaction.BankServices;
import java.io.IOException;
import java.util.Scanner;

public class BankAccountView {

    BankAccount currentAccount;

    public BankAccountView(BankAccount currentAccount) {
        this.currentAccount = currentAccount;
    }


    public void run() throws IOException {

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
                if (!bankServices.transferToBankAccount(amount, accountNumber)) {
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
                else{
                    System.out.println(" You have successfully transferred " + amount + " to " + accountNumber + "");
                }
            } else if (choice == 3) {
                System.out.println("Your balance is: " + bankServices.inquire());
            } else if (choice == 4) {
                BillsView billsView = new BillsView(currentAccount, new BankProvider(currentAccount.getBankName()));
            }

        }


    }

}

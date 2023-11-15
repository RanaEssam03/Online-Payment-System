/// @Author Rana Essam
// Last Modified By: Rana Essam
// last modified: 14-11-2023
/**
 * Description: This clas contains view of the bank account and the user can choose what he wants to do
 * it contains the following methods:
 * 1- run: this method is used to run the bank account view
 */
package views;
import models.Account.WalletAccount;
import providers.Account.WalletProvider;
import services.Transaction.WalletServices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WalletAccountView {

    WalletAccount currentAccount;
    public WalletAccountView(WalletAccount currentAccount){
        this.currentAccount = currentAccount;
    }
    public  void run() throws IOException {

        WalletServices walletServices = new WalletServices(currentAccount.getWalletAccountType().toString(), currentAccount);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n____________________________________________________");
            System.out.println("Please choose one of these options:-");
            System.out.println("1. Transfer to another wallet.");
            System.out.println("2. Inquire balance.");
            System.out.println("3. Transfer to instapay account.");
            System.out.println("4. Pay bills.");
            System.out.println("5. log out.");
            System.out.print("Choice: ");
            int choice;
            choice = in.nextInt();
            if (choice == 5) {
                return;
            }
            if (choice == 1) {
                System.out.println("Please enter the mobile number of the wallet you want to transfer to: ");
                String mobileNumber;
                mobileNumber = in.next();
                System.out.println("Please enter the amount you want to transfer: ");
                double amount;
                amount = in.nextDouble();
                if (walletServices.transfer(amount, mobileNumber)) {
                    System.out.println("Transfer done successfully.");
                } else {
                    System.out.println("you don't have enough balance.");
                }
            } else if (choice == 2) {
                System.out.println("Your balance is: " + walletServices.inquire());

            }
            else if (choice == 3){
                System.out.println("Please enter the username of the instapay account you want to transfer to: ");
                String username;
                double amount;
                username = in.next();
                System.out.println("Please enter the amount you want to transfer: ");
                amount = in.nextDouble();
                boolean notFound = false;
                ArrayList<Boolean> ret = walletServices.transferToInstapayAccount(amount, username,  currentAccount);
                if(ret.get(0) == false ){
                    System.out.println("This username is not found");
                }
                else if (ret.get(1) == false){
                    System.out.println("You don't have enough balance to transfer this amount.");
                }
                else{
                    System.out.println(" You have successfully transferred " + amount + " to " + username + "");
                }

            }
            else if (choice == 4) {
                BillsView billsView = new BillsView(currentAccount, new WalletProvider(currentAccount.getWalletAccountType().toString()));
                billsView.run();
            }
        }
    }
}

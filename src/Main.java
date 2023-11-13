//import models.Account;
//import models.BankAccount;
//import models.WalletAccount;
//import providers.ConnectionAPI;
//import providers.BankConnection;
//import providers.WalletConnection;
//import services.UserServices;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//
//public class Main {
//    public static void mainMenu() throws IOException {
//        while (true) {
//            System.out.println("Please choose one of these options:-");
//            System.out.println("1. Register using bank account.");
//            System.out.println("2. Register using E-Wallet.");
//            System.out.println("3. Exit if you already have an account.");
//            Scanner in = new Scanner(System.in);
//            int choice;
//            choice = in.nextInt();
//            if (choice == 3) {
//                break;
//            }
//            UserServices userServices = new UserServices(); //function's place is here if we put login, logout along with user services
//            switch (choice) {
//                case 1:
//                    Scanner input = new Scanner(System.in);
//                    String [] banks = {"CIB", "HSBC", "National Bank of Egypt"};
//                    System.out.println("Please choose one of these banks:-");
//                    System.out.println("1. " + banks[0]);
//                    System.out.println("2. " + banks[1]);
//                    System.out.println("3. " + banks[2]);
//                    int c;
//                    c = in.nextInt();
//                    if(c - 1 >= banks.length){
//                        System.out.println("Invalid bank choice, please re-enter your choice: ");
//                        c = in.nextInt();
//                    }
//                    Account bankAccount= new BankAccount();
//                    ConnectionAPI bankProvider = new BankConnection("CIB");
//                    System.out.print("Please enter the attached mobile number to your bank account: ");
//                    String mobileNumber;
//                    mobileNumber = input.nextLine();
//                    System.out.println(mobileNumber);
//                    while(!userServices.register(bankAccount, mobileNumber, bankProvider)){
//                        System.out.println("There isn't a bank account with this mobile number, please re-enter your mobile number: ");
//                        mobileNumber = input.nextLine();
//                    }
//                    break;
//                case 2:
//                    Scanner input2 = new Scanner(System.in);
//                    String [] wallets = {"Vodafone Cash", "Fawry"};
//                    System.out.println("Please choose one of these banks:-");
//                    System.out.println("1. " + wallets[0]);
//                    System.out.println("2. " + wallets[1]);
//                    int b;
//                    b = in.nextInt();
//                    if(b - 1 >= wallets.length){
//                        System.out.println("Invalid wallet choice, please re-enter your choice: ");
//                        b = in.nextInt();
//                    }
//                    Account walletAccount = new WalletAccount();
//                    ConnectionAPI walletProvider = new WalletConnection(wallets[b - 1]);
//                    String mobile_number;
//                    mobile_number = input2.nextLine();
//                    while(!userServices.register(walletAccount, mobile_number, walletProvider)){
//                        System.out.print("This mobile number has no wallet, please re-enter your mobile number: ");
//                        mobile_number = input2.nextLine();
//                    }
//                    break;
//                case 3:
//                    break;
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        System.out.println("Welcome to our online payment system");
//        mainMenu();
//        //menu for logging in and using all the app's features
//    }
//}
package Database;

import models.Account.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 The Data class represents the database that stores various types of accounts.
 It includes bank accounts and wallet accounts along with associated information.
 */

public class Data {

    /**
     * The list of all registered accounts.
     */
    public static ArrayList<Account> accounts = new ArrayList<>();

    /**
     * The list of all registered accounts.
     */
    public static ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    /**
     * The list of all registered accounts.
     */
    public static ArrayList<WalletAccount> walletAccounts = new ArrayList<>();

    /**
     * The map that stores CIB bank accounts.
     * Key: mobile number
     * Value: String array with index 0 as bankNumber, index 1 as balance, index 2 as accountType (saving or checking)
     */
    public static Map<String, String[]>  CIBAccounts = new HashMap<>();

    /**
      *The map that stores National Bank accounts.
      */
    public static Map<String, String[]> NationalBankAccounts = new HashMap<>();

    /**
     *The map that stores HSBC Bank accounts.
     */
    public static Map<String, String[]> HSBCAccounts = new HashMap<>();

    /**
     *The map that stores Etisalat Cash Wallet accounts.
     */
    public static Map<String, Double> EtisalatCashAccounts = new HashMap<>();

    /**
     *The map that stores Vodafone Cash Wallet accounts.
     */
    public static Map<String, Double> VodafoneCashAccounts = new HashMap<>();

    /**
     * The map that stores banks and their associated accounts.
     * Key: bank name
     * Value: map of mobile numbers and corresponding account information
     */
    public static Map<String, Map<String, String[]>> banksMap = new HashMap<String, Map<String, String[]>>();

    /**
     * The map that stores wallets and their associated accounts.
     * Key: wallet name
     * Value: map of mobile numbers and corresponding account balances
     */
    public static Map<String, Map<String, Double>> walletsMap = new HashMap<String, Map<String, Double>>();


    /**
     * Sets up the initial set of accounts in the database.
     */
    public static void setCurrentAccounts(){
        String userName, mobile, email, password;
        String accountNumber;
        double balance;
        userName = "nour@instapay";
        mobile = "01114335538";
        email = "nourmuhammad835@gmail.com";
        password = "Software2023$";
        balance = 10000;
        accountNumber = "2210";
        BankAccount account = new BankAccount(userName, mobile, password, balance, email);
        account.setAccountType(BankAccountType.Saving);
        account.setAccountNumber(accountNumber);
        account.setBankName("CIB");
        String tempBalance;
        tempBalance = Double.toString(balance);
        CIBAccounts.put(mobile, new String[]{accountNumber, tempBalance,account.getAccountType().toString()});
        accounts.add(account);
        bankAccounts.add(account);
        userName = "noor@instapay";
        mobile = "01114335538";
        email = "nooreyad835@gmail.com";
        password = "Software2023$";
        balance = 90000;
        accountNumber = "39";
        tempBalance = Double.toString(balance);
        BankAccount account2 = new BankAccount(userName, mobile, password, balance, email);
        account2.setAccountType(BankAccountType.Saving);
        account2.setAccountNumber(accountNumber);
        account.setBankName("National Bank of Egypt");
        NationalBankAccounts.put(mobile, new String[]{accountNumber, tempBalance, account.getAccountType().toString()});
        accounts.add(account2);
        bankAccounts.add(account2);
        userName = "mariam@instapay";
        mobile = "01114335538";
        email = "mariamhaitham835@gmail.com";
        password = "Software2023$";
        balance = 70000;
        accountNumber = "14";
        tempBalance = Double.toString(balance);
        BankAccount account3 = new BankAccount(userName, mobile, password, balance, email);
        account3.setAccountType(BankAccountType.Checking);
        account3.setAccountNumber(accountNumber);
        account.setBankName("HSBC");
        HSBCAccounts.put(mobile, new String[]{accountNumber, tempBalance, account.getAccountType().toString()});
        accounts.add(account3);
        bankAccounts.add(account3);
        userName = "rana@instapay";
        mobile = "01114335538";
        email = "ranaessam835@gmail.com";
        password = "Software2023$";
        balance = 80000;
        WalletAccount account4 = new WalletAccount(userName, mobile, password, balance, email);
        account4.setWalletAccountType(WalletAccountType.VodafoneCash);
        VodafoneCashAccounts.put(mobile, balance);
        accounts.add(account4);
        walletAccounts.add(account4);
        userName = "merna@instapay";
        mobile = "01114335538";
        email = "mernaislam835@gmail.com";
        password = "Software2023$";
        balance = 30000;
        WalletAccount account5 = new WalletAccount(userName, mobile, password, balance, email);
        account5.setWalletAccountType(WalletAccountType.EtisalatCash);
        EtisalatCashAccounts.put(mobile, balance);
        accounts.add(account5);
        walletAccounts.add(account5);
        CIBAccounts.put("01122334455", new String[]{"127", "7000", "Checking"});
        NationalBankAccounts.put("01122334455", new String[]{"128", "7000", "Checking"});
        HSBCAccounts.put("01122334455", new String[]{"129", "7000", "Checking"});
        VodafoneCashAccounts.put("01032750535", 6000.0);
        EtisalatCashAccounts.put("01122334455", 5000.0);
        banksMap.put("CIB", CIBAccounts);
        banksMap.put("National Bank of Egypt", NationalBankAccounts);
        banksMap.put("HSBC", HSBCAccounts);
        walletsMap.put("Vodafone Cash", VodafoneCashAccounts);
        walletsMap.put("Etisalat Cash", EtisalatCashAccounts);
    }
}

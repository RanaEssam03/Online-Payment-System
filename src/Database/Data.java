package Database;

import models.Account.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    public static ArrayList<WalletAccount> walletAccounts = new ArrayList<>();
    //key: mobile number,
    // value: index0 bankNumber, index1 balance, index2 accountType(saving or checking)
    public static Map<String, String[]>  CIBAccounts = new HashMap<>();
    public static Map<String, String[]> NationalBankAccounts = new HashMap<>();
    public static Map<String, String[]> HSBCAccounts = new HashMap<>();
    public static Map<String, Double> EtisalatCashAccounts = new HashMap<>();
    public static Map<String, Double> VodafoneCashAccounts = new HashMap<>();
    public static Map<String, Map<String, String[]>> banksMap = new HashMap<String, Map<String, String[]>>();
    public static Map<String, Map<String, Double>> walletsMap = new HashMap<String, Map<String, Double>>();


    public static void setCurrentAccounts(){
        String userName, mobile, email, password;
        String accountNumber;
        double balance;
        userName = "nourmuhammad@instapay";
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
        userName = "noureyad@instapay";
        mobile = "01114335538";
        email = "nooreyad835@gmail.com";
        password = "Software2023$";
        balance = 90000;
        accountNumber = "2211";
        tempBalance = Double.toString(balance);
        BankAccount account2 = new BankAccount(userName, mobile, password, balance, email);
        account2.setAccountType(BankAccountType.Saving);
        account2.setAccountNumber(accountNumber);
        CIBAccounts.put(mobile, new String[]{accountNumber, tempBalance, account.getAccountType().toString()});
        accounts.add(account2);
        bankAccounts.add(account2);
        userName = "ranaessam@instapay";
        mobile = "01114335538";
        email = "ranaessam835@gmail.com";
        password = "Software2023$";
        balance = 80000;
        WalletAccount account3 = new WalletAccount(userName, mobile, password, balance, email);
        account3.setWalletAccountType(WalletAccountType.VodafoneCash);
        VodafoneCashAccounts.put(mobile, balance);
        accounts.add(account3);
        walletAccounts.add(account3);
        NationalBankAccounts.put("01007429819", new String[]{"128", "7000", "Checking"});
        EtisalatCashAccounts.put("01007104077", 6000.0);
        banksMap.put("CIB", CIBAccounts);
        banksMap.put("National Bank of Egypt", NationalBankAccounts);
        banksMap.put("HSBC", HSBCAccounts);
        walletsMap.put("Vodafone Cash", VodafoneCashAccounts);
        walletsMap.put("Etisalat Cash", EtisalatCashAccounts);
    }
}

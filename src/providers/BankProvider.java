package providers;//package providers;
//
//import java.io.*;
//import java.util.Objects;
//
//public class BankProvider extends APIProvider{
//    public BankProvider(String name){
//        super(name);
//    }
//    @Override
//    public double verifyAccount(String mobileNumber) throws IOException {
//        double balance = -1;
//        String fileSeparator = System.getProperty("file.separator");
//        String filename = this.getName().replaceAll("\\s", "") + ".txt";
//        String path = System.getProperty("user.dir") + fileSeparator + filename;
//        System.out.println(path);
//        File file = new File(path);
//        if(file.exists()){
//            System.out.println("heree bank");
//        }
////        String line;
////        String[] data;
////        BufferedReader reader = new BufferedReader(new FileReader(file));
////        while((line = reader.readLine()) != null){
////            data= line.split(" ");
////            if(Objects.equals(mobileNumber, data[0])){
////                balance = Double.parseDouble(data[1]);
////                break;
////            }
////        }
////        reader.close();
//        return balance;
//    }
//
//    public boolean verifyAccountNumber(String accountNumber) throws IOException {
//        boolean found = false;
//        String fileSeparator = System.getProperty("file.separator");
//        String filename = this.getName().replaceAll("\\s", "") + ".txt";
//        String path = System.getProperty("user.dir") + fileSeparator + filename;
//        System.out.println(path);
//        File file = new File(path);
//      // TODO: verify account number exists in the bank
//        return found;
//        }
//
//}

import java.io.IOException;

public class BankProvider extends TransactionProvider {


    public BankProvider(String name) {
        super(name);
    }

    @Override
    public double getBalance(String mobileNumber) throws IOException {
        return 0;
    }

    @Override
    public boolean withDraw(double amount) {
        return false;
    }

    @Override
    public boolean transferToWallet(double amount, String mobileNumber) throws IOException {
        return false;
    }

    public boolean transferToBank(double amount, String accountNumber) throws IOException {
        return false;
    }
}

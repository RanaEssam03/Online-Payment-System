package providers;//package providers;
//
//import java.io.*;
//import java.util.Objects;
//
//public class WalletProvider extends APIProvider{
//
//    public WalletProvider(String name) {
//        super(name);
//    }
//
//    @Override
//    public double verifyAccount(String mobileNumber) throws IOException {
//        double balance = -1;
//        String fileSeparator = System.getProperty("file.separator");
//        String path = System.getProperty("user.dir") + fileSeparator + this.getName().replaceAll("\\s", "") + ".txt";
//        File file = new File(path);
//        if(file.exists()){
//            System.out.println("heree wallet");
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
//}

import providers.TransactionProvider;

import java.io.IOException;

public class WalletProvider extends TransactionProvider {

    public WalletProvider(String name) {
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
}
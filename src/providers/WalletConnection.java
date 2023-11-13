//package providers;
//
//import java.io.*;
//
//public class WalletConnection extends ConnectionAPI {
//
//    public WalletConnection(String name) {
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

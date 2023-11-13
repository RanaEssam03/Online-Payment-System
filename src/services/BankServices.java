package services;//package services;
//
//public class BankServices extends TransactionServices {
//
//
//    public void transferToBankAccount(int amount, String accountNumber){
//        System.out.println("Transfer to bank account using bank services " + apiProvider.getName());
//    }
//
//}

import providers.BankProvider;

import java.io.IOException;

public class BankServices extends TransactionServices implements TransferringToBankAccount {
    BankServices(String name) {
        BankProvider bankProvider = new BankProvider(name);
        super.transactionProvider = bankProvider;

    }


    @Override
    public void transferToBankAccount(int amount, String accountNumber) throws IOException {

//         ?? ?
//       if(transactionProvider.transferToBank(amount, accountNumber)){
//           account.setBalance(account.getBalance() - amount);
//       }
    }
}
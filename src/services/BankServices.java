package services;

public class BankServices extends TransactionServices {


    public void transferToBankAccount(int amount, String accountNumber){
        System.out.println("Transfer to bank account using bank services " + apiProvider.getName());
    }

}

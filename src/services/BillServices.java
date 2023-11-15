package services;

import models.Account.Account;
import models.Bills.Bill;
import providers.Account.AccountProvider;
import providers.BillPayment.BillCompany;

import java.util.Random;

public  class BillServices {
    BillCompany billCompany;
    AccountProvider transactionProvider;

    public BillServices(BillCompany billCompany, AccountProvider transactionProvider) {
        this.billCompany = billCompany;
        this.transactionProvider = transactionProvider;
    }

    public Bill inquire(){
        Random random = new Random();
        Integer customerID = random.nextInt(1000);
        return billCompany.getBill(customerID);
    }
    public boolean pay(Bill bill, Account currentAccount){
       if(transactionProvider.withdraw(bill.getBillAmount(), currentAccount)) {
           currentAccount.setBalance(currentAccount.getBalance() - bill.getBillAmount());
           return billCompany.confirmPayment();
       }
        return false;
    }
}

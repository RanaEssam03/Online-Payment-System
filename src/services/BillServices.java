package services;

import models.Account.Account;
import models.Bills.Bill;
import providers.BillPayment.BillCompany;
import providers.Transaction.TransactionProvider;

public  class BillServices {
    BillCompany billCompany;
    TransactionProvider transactionProvider;

    public BillServices(BillCompany billCompany, TransactionProvider transactionProvider) {
        this.billCompany = billCompany;
        this.transactionProvider = transactionProvider;
    }

    public Bill inquire(){
        return billCompany.getBill();
    }
    public boolean pay(Bill bill, Account currentAccount){
       if(transactionProvider.withdraw(bill.getBillAmount(), currentAccount))
           return billCompany.confirmPayment();

        return false;
    }
}

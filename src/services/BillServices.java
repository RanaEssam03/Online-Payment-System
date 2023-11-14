package services;

import models.Account;
import models.Bills.Bill;
import providers.BillPayment.BillCompany;
import providers.BillPayment.ElectricityCompany;
import providers.BillPayment.GasCompany;
import providers.Transaction.TransactionProvider;
import providers.BillPayment.WaterCompany;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public  class BillServices {
    BillCompany billCompany;
    TransactionProvider transactionProvider;

    public BillServices(BillCompany billCompany, TransactionProvider transactionProvider) {
        this.billCompany = billCompany;
        this.transactionProvider = transactionProvider;
    }

    public Bill inquire(){
        Random random = new Random();
        Integer customerID = random.nextInt(1000);
        return billCompany.getBill(customerID);
    }
    public boolean pay(Bill bill, Account currentAccount){
       if(transactionProvider.withdraw(bill.getBillAmount(), currentAccount))
           return billCompany.confirmPayment();

        return false;
    }
}

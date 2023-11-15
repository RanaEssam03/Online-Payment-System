package services;

import models.Account.Account;
import models.Bills.Bill;
import providers.Account.AccountProvider;
import providers.BillPayment.BillCompany;

import java.util.Random;

/**
 * The {@code BillServices} class provides services for handling bills, including inquiries and payments.
 * It interacts with a {@code BillCompany} and an {@code AccountProvider} to retrieve bills and process payments.
 */
public class BillServices {
    BillCompany billCompany;
    AccountProvider transactionProvider;

    /**
     * Constructs a new {@code BillServices} instance with the specified bill company and account provider.
     *
     * @param billCompany         the company providing bills for payment
     * @param transactionProvider the provider for account transactions
     */
    public BillServices(BillCompany billCompany, AccountProvider transactionProvider) {
        this.billCompany = billCompany;
        this.transactionProvider = transactionProvider;
    }

    /**
     * Inquires about a bill by generating a random customer ID and retrieving the corresponding bill.
     *
     * @return the bill information for the generated customer ID
     */
    public Bill inquire() {
        Random random = new Random();
        Integer customerID = random.nextInt(1000);
        return billCompany.getBill(customerID);
    }

    /**
     * Pays the specified bill using the provided current account.
     * If the payment is successful, updates the account balance and confirms the payment with the bill company.
     *
     * @param bill           the bill to be paid
     * @param currentAccount the account from which to make the payment
     * @return {@code true} if the payment is successful, {@code false} otherwise
     */
    public boolean pay(Bill bill, Account currentAccount) {
        if (transactionProvider.withdraw(bill.getBillAmount(), currentAccount)) {
            currentAccount.setBalance(currentAccount.getBalance() - bill.getBillAmount());
            return billCompany.confirmPayment();
        }
        return false;
    }
}

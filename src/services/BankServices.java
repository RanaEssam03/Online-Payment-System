package services;

public class BankServices extends TransactionServices {
    @Override
    void transfer() {
        System.out.println("Transfer using bank services");
    }

    @Override
    double inquire() {
        System.out.println("Inquire using bank services");
        return 0;
    }

    @Override
    void payBills() {
        System.out.println("Pay bills using bank services");
    }
}

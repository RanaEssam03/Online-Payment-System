package services;

public class WalletServices extends TransactionServices{
    @Override
    void transfer() {
        System.out.println("Transfer using wallet services");
    }

    @Override
    double inquire() {
        System.out.println("Inquire using wallet services");
        return 0;
    }

    @Override
    void payBills() {
        System.out.println("Pay bills using wallet services");
    }
}

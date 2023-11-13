package services.Transaction;

import java.io.IOException;

public interface TransferringToBankAccount {
    public void transferToBankAccount(int amount, String accountNumber) throws IOException;
}


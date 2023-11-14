package providers.verification;

import providers.AccountNumberGetter;
import providers.BalanceGetter;

import static Database.Data.*;

public class BankVerification extends Verification implements BalanceGetter, AccountNumberGetter {
    @Override
    public boolean verifyAccount(String mobileNumber, String verifier) {
        return banksMap.get(verifier).containsKey(mobileNumber);
    }

    @Override
    public double getBalance(String mobileNumber, String verifier) {
        String s = banksMap.get(verifier).get(mobileNumber)[1];
        return Double.parseDouble(s);
    }

    @Override
    public String getAccountNumber(String mobileNumber, String verifier) {
        return banksMap.get(verifier).get(mobileNumber)[0];
    }
}
